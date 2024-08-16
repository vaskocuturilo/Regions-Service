import './App.css';
import React, {useEffect, useRef, useState} from "react";
import apiClient from "./http-common";
import upload from './img/upload.png';
import logo from './img/europe-plates.jpg';
import $ from 'jquery';
import JSONPretty from 'react-json-pretty';
import {createWorker} from "tesseract.js";
import 'bootstrap/dist/css/bootstrap.css';
import Header from './components/Header';
import Popup from './components/Popup';
import '@popperjs/core';
import LocationMarker from './components/MapView';
import ImageManager from './components/ImageManager';

function App() {
    const imageManager = new ImageManager();

    const [plates, setPlates] = useState("Choose country");
    const [diplomatic, setDiplomatic] = useState("Choose country");


    const getRegion = useRef(null);
    const getDescription = useRef(null);

    const image = useRef(null);
    const typePlates = useRef(null);

    const getDiplomaticRegion = useRef(null);
    const getDiplomaticDescription = useRef(null);

    const [getResult, setGetResult] = useState(null);


    const regionRef = useRef(null);
    const diplomaticRef = useRef(null);


    const [selected, setSelected] = useState("");

    const [file, setFile] = useState("");

    const [ocr, setOcr] = useState("");

    const [imageData, setImageData] = useState(null);

    const [seconds, setSeconds] = useState(0);
    const [minutes, setMinutes] = useState(2);

    const [isShown, setIsShown] = useState(false);

    const changeHandler = e => {
        setSelected(e.target.value);
    };

    const formatResponse = (res) => {
        return JSON.stringify(res, null, 2);
    };

    async function getPlatesByRegion() {
        const region = getRegion.current.value;

        const selectValue = regionRef.current.value;

        if (selectValue === 'None') {
            alert('Choose any country first');
            return;
        }

        if (region === '') {
            alert('Choose region first');
            return;
        }

        if (region) {
            try {
                const res = await apiClient.get(`/${plates}/plates/region/${region}`);

                const result = {
                    information: res.data
                };

                setGetResult(formatResponse(result));
                getRegion.current.value = '';
                setIsShown(true);
            } catch (err) {
                if (!err?.response) {
                    alert("No Server Response");
                    return;
                }
                setGetResult(formatResponse(err.response?.data || err));
                getRegion.current.value = '';
            }
        }
    }

    async function getDiplomaticPlatesByRegion() {
        const region = getDiplomaticRegion.current.value;

        const selectValue = diplomaticRef.current.value;

        if (selectValue === 'None') {
            alert('Choose any country first');
            return;
        }

        if (region === '') {
            alert('Choose region first');
            return;
        }

        if (region) {
            try {
                const res = await apiClient.get(`/${diplomatic}/diplomatic/plates/region/${region}`);

                const result = {
                    information: res.data
                };

                setGetResult(formatResponse(result));
                getDiplomaticRegion.current.value = '';
                setIsShown(true);
            } catch (err) {
                if (!err?.response) {
                    alert("No Server Response");
                    return;
                }
                setGetResult(formatResponse(err.response?.data || err));
                getDiplomaticRegion.current.value = '';
            }
        }
    }

    async function getPlatesByDescription() {
        const description = getDescription.current.value;

        const selectValue = regionRef.current.value;

        if (selectValue === 'None') {
            alert('Choose any country first');
            return;
        }

        if (description === '') {
            alert('Choose region first');
            return;

        }

        if (description) {
            try {
                const res = await apiClient.get(`/${plates}/plates/description/${description}`);

                const result = {
                    information: res.data
                };

                setGetResult(formatResponse(result));
                getDescription.current.value = '';
                setIsShown(true);
            } catch (err) {
                if (!err?.response) {
                    alert("No Server Response");
                    return;
                }
                setGetResult(formatResponse(err.response?.data || err));
                getDescription.current.value = '';
            }
        }
    }

    async function getDiplomaticPlatesByDescription() {
        const description = getDiplomaticDescription.current.value;

        const selectValue = diplomaticRef.current.value;

        if (selectValue === 'None') {
            alert('Choose any country first');
            return;
        }


        if (description === '') {
            alert('Choose region first');
            return;
        }

        if (description) {
            try {
                const res = await apiClient.get(`/${diplomatic}/diplomatic/plates/description/${description}`);

                const result = {
                    information: res.data
                };

                setGetResult(formatResponse(result));
                getDiplomaticDescription.current.value = '';
                setIsShown(true);
            } catch (err) {
                if (!err?.response) {
                    alert("No Server Response");
                    return;
                }
                setGetResult(formatResponse(err.response?.data || err));
                getDiplomaticDescription.current.value = '';
            }
        }
    }

    function resetState() {
        setFile('');
        image.current.src = logo;
        setGetResult(null);
        setPlates('');
        getRegion.current.value = '';
        getDescription.current.value = '';
        typePlates.current.classList.remove('hidden');
        setIsShown(false);
    }

    const clearGetOutputPrivatePlates = () => {
        resetState();
    };

    const clearGetOutputDiplomaticPlates = () => {
        resetState();
    };

    const simplePlates = (e) => {
        setPlates(e.target.value);
        document.getElementById('countries_image').src = imageManager.getCountryImage(e.target.value);
        typePlates.current.classList.add('hidden');
    };

    const diplomaticPlates = (e) => {
        setDiplomatic(e.target.value);
        document.getElementById('countries_image').src = imageManager.getDiplomaticImage(e.target.value);
        typePlates.current.classList.add('hidden');
    };

    $(document).on("change", "#countries_list", function (e) {
        $('#countries_diplomatic_list').val('None');
    });

    $(document).on("change", "#countries_diplomatic_list", function (e) {
        $('#countries_list').val('None');
    });

    const convertImageToText = async () => {
        if (!imageData) return;
        const worker = await createWorker();
        await worker.load();
        await worker.loadLanguage('eng');
        await worker.initialize('eng');
        const {
            data: {text},
        } = await worker.recognize(imageData);
        setOcr(text);
        console.log(`This is result: ${text}`);
        await worker.terminate();
    };

    useEffect(() => {
        convertImageToText().then()
    }, [imageData]);

    const [showElement, setShowElement] = React.useState(true)
    useEffect(() => {
            setTimeout(function () {
                setShowElement(false);
                setIsShown(false);
                image.current.src = logo;
            }, 120000);
        },
        []);

    function updateTime() {
        const shouldReset = minutes === 0 && seconds === 0;
        const shouldDecrementMinutes = seconds === 0 && !shouldReset;

        setMinutes(shouldReset ? 5 : shouldDecrementMinutes ? minutes - 1 : minutes);
        setSeconds(shouldReset ? 0 : shouldDecrementMinutes ? 59 : seconds - 1);
    }

    useEffect(() => {
        const timeOut = setTimeout(updateTime, 1000)

        return function cleanUp() {
            clearTimeout(timeOut);
        }
    });

    return (
        <div className="App">
            <Header></Header>
            <Popup></Popup>
            <img id="countries_image" src={file ? URL.createObjectURL(file) : logo} ref={image} alt="this is main image"
                 className='center'/>
            {showElement ? <div>
                <div className="center alert alert-info mt-2" data-cy="alert_message_block" ref={typePlates}>Please
                    choose
                    any type of plates
                </div>
                <input
                    type="radio"
                    name="plates"
                    value="private_plates"
                    id="private_plates"
                    checked={selected === "private_plates"}
                    onChange={changeHandler}
                    data-cy="private_radio_button"
                    onClick={clearGetOutputPrivatePlates}
                />
                <label htmlFor="private_plates" data-cy="private_label">Private plates</label>
                <div aria-hidden={selected !== "private_plates"}>
                    <select value={plates} name="countries_plates" id="countries_list"
                            onChange={simplePlates}
                            className="form__input center" ref={regionRef} data-cy="countries_drop_down">
                        <option value="None">Choose country</option>
                        <option value="armenia">🇦🇲&emsp;Armenia</option>
                        <option value="austria">🇦🇹&emsp;Austria</option>
                        <option value="azerbaijan">🇦🇿&emsp;Azerbaijan</option>
                        <option value="belarus">🇧🇾&emsp;Belarus</option>
                        <option value="british">🇻🇬&emsp;Great Britain</option>
                        <option value="bulgaria">🇧🇬&emsp;Bulgaria</option>
                        <option value="croatia">🇭🇷&emsp;Croatia</option>
                        <option value="czech">🇨🇿&emsp;Czech Republic</option>
                        <option value="estonia">🇪🇪&emsp;Estonia</option>
                        <option value="france">🇫🇷&emsp;France</option>
                        <option value="germany">🇩🇪&emsp;Germany</option>
                        <option value="greece">🇬🇷&emsp;Greece</option>
                        <option value="hungary">🇭🇺&emsp;Hungary</option>
                        <option value="ireland">🇮🇪&emsp;Ireland</option>
                        <option value="italian">🇮🇹&emsp;Italy</option>
                        <option value="kazakhstan">🇰🇿&emsp;Kazakhstan</option>
                        <option value="kosovo">🇽🇰&emsp;Kosovo</option>
                        <option value="kyrgyzstan">🇰🇬&emsp;Kyrgyzstan</option>
                        <option value="lithuania">🇱🇹&emsp;Lithuania</option>
                        <option value="malaysia">🇲🇾&emsp;Malaysia</option>
                        <option value="moldova">🇲🇩&emsp;Moldova</option>
                        <option value="montenegro">🇲🇪&emsp;Montenegro</option>
                        <option value="norway">🇳🇴&emsp;Norway</option>
                        <option value="macedonia">🇲🇰&emsp;North Macedonia</option>
                        <option value="poland">🇵🇱&emsp;Poland</option>
                        <option value="romania">🇷🇴&emsp;Romania</option>
                        <option value="russia">🇷🇺&emsp;Russia</option>
                        <option value="serbia">🇷🇸&emsp;Serbia</option>
                        <option value="slovakia">🇸🇰&emsp;Slovakia</option>
                        <option value="slovenia">🇸🇮&emsp;Slovenia</option>
                        <option value="sweden">🇸🇪&emsp;Sweden</option>
                        <option value="switzerland">🇨🇭&emsp;Switzerland</option>
                        <option value="turkey">🇹🇷&emsp;Turkey</option>
                        <option value="ukraine">🇺🇦&emsp;Ukraine</option>
                        <option value="uzbekistan">🇺🇿&emsp;Uzbekistan</option>
                    </select>
                    <br/>
                    <div id="app" className="container">
                        <div className="card">
                            <div className="card-body">
                                <div className="input-group input-group-sm">
                                    <input type="text" ref={getRegion} className="form-control ml-2"
                                           placeholder="Region" data-cy="region_plates_input"/>
                                    <div className="input-group-append">
                                        <button className="btn btn-sm btn-primary" id='button1'
                                                onClick={getPlatesByRegion} data-cy="get_plates_by_region_button">By
                                            region
                                        </button>
                                    </div>
                                    <input type="text" ref={getDescription} className="form-control ml-2"
                                           placeholder="Description" data-cy="description_plates_input"/>

                                    <div className="input-group-append">
                                        <button className="btn btn-sm btn-primary" id='button2'
                                                onClick={getPlatesByDescription}
                                                data-cy="get_plates_by_description_button">By description
                                        </button>
                                    </div>
                                </div>
                                <JSONPretty id="json-pretty" style={{fontSize: "1.1em", textAlign: 'left'}}
                                            data={getResult} mainStyle="padding:1em"
                                            valueStyle="font-size:1.5em"></JSONPretty>
                            </div>
                            <button className="btn btn-primary" onClick={clearGetOutputPrivatePlates}
                                    data-cy="clear_button">Clear
                            </button>
                        </div>
                    </div>
                </div>
                <input
                    type="radio"
                    value="diplomatic_plates"
                    id="diplomatic_plates"
                    checked={selected === "diplomatic_plates"}
                    name="plates"
                    onChange={changeHandler}
                    data-cy="diplomatic_radio_button"
                    onClick={clearGetOutputDiplomaticPlates}
                />
                <label htmlFor="diplomatic_plates" data-cy="diplomatic_label">Diplomatic plates</label>
                <div aria-hidden={selected !== "diplomatic_plates"}>
                    <select value={diplomatic} name="diplomatic_plates" id="countries_diplomatic_list"
                            onChange={diplomaticPlates}
                            className="form__input center" ref={diplomaticRef} data-cy="diplomatic_drop_down">
                        <option value="None">Choose country</option>
                        <option value="austria">🇦🇹&emsp;Austria</option>
                        <option value="croatia">🇭🇷&emsp;Croatia</option>
                        <option value="estonia">🇪🇪&emsp;Estonia</option>
                        <option value="france">🇫🇷&emsp;France</option>
                        <option value="germany">🇩🇪&emsp;Germany</option>
                        <option value="italian">🇮🇹&emsp;Italy</option>
                        <option value="kyrgyzstan">🇰🇬&emsp;Kyrgyzstan</option>
                        <option value="lithuania">🇱🇹&emsp;Lithuania</option>
                        <option value="malaysia">🇲🇾&emsp;Malaysia</option>
                        <option value="montenegro">🇲🇪&emsp;Montenegro</option>
                        <option value="norway">🇳🇴&emsp;Norway</option>
                        <option value="poland">🇵🇱&emsp;Poland</option>
                        <option value="romania">🇷🇴&emsp;Romania</option>
                        <option value="portugal">🇵🇹&emsp;Portugal</option>
                        <option value="russia">🇷🇺&emsp;Russia</option>
                        <option value="sweden">🇸🇪&emsp;Sweden</option>
                        <option value="switzerland">🇨🇭&emsp;Switzerland</option>
                    </select>

                    <br/><br/><br/>
                    <div id="app" className="container">
                        <div className="card">
                            <div className="card-body">
                                <div className="input-group input-group-sm">
                                    <input type="text" ref={getDiplomaticRegion} className="form-control ml-2"
                                           placeholder="Region" data-cy="region_diplomatic_plates_input"/>
                                    <br/>
                                    <div className="input-group-append">
                                        <button className="btn btn-sm btn-primary" id='button3'
                                                onClick={getDiplomaticPlatesByRegion}
                                                data-cy="get_diplomatic_plates_by_region_button">By region
                                        </button>
                                    </div>
                                    <br/>
                                    <input type="text" ref={getDiplomaticDescription} className="form-control ml-2"
                                           placeholder="Description" data-cy="get_by_diplomatic_description_input"/>
                                    <div className="input-group-append">
                                        <button className="btn btn-sm btn-primary" id='button4'
                                                onClick={getDiplomaticPlatesByDescription}
                                                data-cy="get_diplomatic_plates_by_description">By description
                                        </button>
                                    </div>
                                    <br/>
                                </div>
                                <JSONPretty id="json-pretty" style={{fontSize: "1.1em", textAlign: 'left'}}
                                            data={getResult} mainStyle="padding:1em"
                                            valueStyle="font-size:1.5em"></JSONPretty>
                            </div>
                            <button className="btn btn-primary" onClick={clearGetOutputDiplomaticPlates}
                                    data-cy="clear_button">Clear
                            </button>
                        </div>

                    </div>
                </div>
                <input
                    type="radio"
                    name="plates"
                    value="upload_photo"
                    id="upload_photo"
                    checked={selected === "upload_photo"}
                    onChange={changeHandler}
                    data-cy="upload_photo_radio_button"
                />
                <label htmlFor="upload_photo" data-cy="upload_photo_label">Upload Photo</label>
                <div aria-hidden={selected !== "upload_photo"}>
                    <h3 data-cy="upload_photo_h3_text">Upload photo with car plate</h3>
                    <div className="image-upload">
                        <label form="file-input">
                            <img src={upload} data-cy="upload_photo_image"/>
                        </label>
                        <input id="file-input" type="file" onChange={(e) => setFile(e.target.files[0])}
                               data-cy="upload_photo"/>
                    </div>
                </div>
                <p className="logout-timer">
                    You will be logged out in <span
                    className="timer">time: {minutes.toString().padStart(2, '0')}:{seconds.toString().padStart(2, '0')}</span>
                </p>
            </div> : <></>}
            {isShown && <LocationMarker/>}
        </div>
    );
}

export default App;
