import './App.css';
import React, {useEffect, useRef, useState} from "react";
import logo from './img/europe-plates.jpg';
import upload from './img/upload.png';
import $ from 'jquery';
import JSONPretty from 'react-json-pretty';
import 'bootstrap/dist/css/bootstrap.css';
import Header from './components/Header';
import Popup from './components/Popup';
import '@popperjs/core';
import LocationMarker from './components/MapView';
import ImageManager from './components/ImageManager';
import apiClient from './api/http-common';
import countriesForPlates from './countries/countriesForPlates';
import countriesForDiplomaticPlates from './countries/countriesForDiplomaticPlates';
import CountrySelect from "./components/CountrySelect";
import Timer from "./components/Timer";
import {RegularPlateService} from './service/RegularPlateService';
import {DiplomaticPlateService} from './service/DiplomaticPlateService';

function App() {
    const imageManager = new ImageManager();

    const [plates, setPlates] = useState("Choose country");

    const [diplomatic, setDiplomatic] = useState("Choose country");

    const image = useRef(null);

    const typePlates = useRef(null);

    const [selected, setSelected] = useState("");

    const [file, setFile] = useState("");

    const [getResult, setGetResult] = useState('');

    const [isShown, setIsShown] = useState(false);

    const regionRef = useRef();

    const diplomaticRef = useRef();

    const getRegion = useRef();

    const getDescription = useRef();

    const getDiplomaticRegion = useRef();

    const getDiplomaticDescription = useRef();

    const handleGetPlatesByRegion = () => {
        const plateService = new RegularPlateService(apiClient, getRegion, setGetResult, setIsShown, regionRef);
        plateService.getPlatesByRegion(plates)
            .then(result => console.log('Success:', result))
            .catch(error => console.error('Error:', error));
    };

    const handleGetPlatesByDescription = () => {
        const plateService = new RegularPlateService(apiClient, getDescription, setGetResult, setIsShown, regionRef);
        plateService.getPlatesByDescription(plates)
            .then(result => console.log('Success:', result))
            .catch(error => console.error('Error:', error));
    };

    const handleGetDiplomaticPlatesByRegion = () => {
        const diplomaticPlateService = new DiplomaticPlateService(apiClient, getDiplomaticRegion, setGetResult, setIsShown, diplomaticRef);
        diplomaticPlateService.getPlatesByRegion(diplomatic)
            .then(result => console.log('Success:', result))
            .catch(error => console.error('Error:', error));
    };
    const handleGetDiplomaticPlatesByDescription = () => {
        const diplomaticPlateService = new DiplomaticPlateService(apiClient, getDiplomaticDescription, setGetResult, setIsShown, diplomaticRef);
        diplomaticPlateService.getPlatesByDescription(diplomatic)
            .then(result => console.log('Success:', result))
            .catch(error => console.error('Error:', error));
    };

    const clearGetOutputPlates = (plateSetter, regionRef, descriptionRef) => {
        setFile('');
        image.current.src = logo;
        setGetResult(null);
        plateSetter('');
        regionRef.current.value = '';
        descriptionRef.current.value = '';
        typePlates.current.classList.remove('hidden');
        setIsShown(false);
    };

    const clearGetOutputPrivatePlates = () => {
        clearGetOutputPlates(setPlates, getRegion, getDescription)
    };

    const clearGetOutputDiplomaticPlates = () => {
        clearGetOutputPlates(setDiplomatic, getDiplomaticRegion, getDiplomaticDescription)
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

    $(document).on("change", "#countries_list", () => {
        $('#countries_diplomatic_list').val('None');
    });

    $(document).on("change", "#countries_diplomatic_list", () => {
        $('#countries_list').val('None');
    });

    const [showElement, setShowElement] = React.useState(true)

    useEffect(() => {
            setTimeout(function () {
                setShowElement(false);
                setIsShown(false);
                image.current.src = logo;
            }, 120000);
        },
        []);

    return (
        <div className="App">
            <Header/>
            <Popup/>
            <img id="countries_image" src={file ? URL.createObjectURL(file) : logo} ref={image}
                 alt="this is main image" className='center'/>
            {showElement ? <div>
                <div className="center alert alert-info mt-2" data-cy="alert_message_block" ref={typePlates}>Please
                    choose any type of plates
                </div>

                <input
                    type="radio"
                    name="plates"
                    value="private_plates"
                    id="private_plates"
                    checked={selected === "private_plates"}
                    onChange={(e) => setSelected(e.target.value)}
                    data-cy="private_radio_button"
                    onClick={clearGetOutputPrivatePlates}
                />
                <label htmlFor="private_plates" data-cy="private_label">Private plates</label>
                <div aria-hidden={selected !== "private_plates"}>
                    <CountrySelect
                        countries={countriesForPlates}
                        value={plates}
                        onChange={simplePlates}
                        id="countries_list"
                        selectRef={regionRef}
                    />
                    <br/>
                    <div id="app" className="container">
                        <div className="card">
                            <div className="card-body">
                                <div className="input-group input-group-sm">
                                    <input type="text" ref={getRegion} className="form-control ml-2"
                                           placeholder="Region" data-cy="region_plates_input"/>
                                    <div className="input-group-append">
                                        <button className="btn btn-sm btn-primary" id='button1'
                                                onClick={handleGetPlatesByRegion}
                                                data-cy="get_plates_by_region_button">By region
                                        </button>
                                    </div>
                                    <input type="text" ref={getDescription} className="form-control ml-2"
                                           placeholder="Description" data-cy="description_plates_input"/>
                                    <div className="input-group-append">
                                        <button className="btn btn-sm btn-primary" id='button2'
                                                onClick={handleGetPlatesByDescription}
                                                data-cy="get_plates_by_description_button">By description
                                        </button>
                                    </div>
                                </div>
                                <JSONPretty
                                    id="json-pretty"
                                    style={{fontSize: "1.1em", textAlign: 'left'}}
                                    data={getResult}
                                    mainStyle="padding:1em"
                                    valueStyle="font-size:1.5em">
                                </JSONPretty>
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
                    onChange={(e) => setSelected(e.target.value)}
                    data-cy="diplomatic_radio_button"
                    onClick={clearGetOutputDiplomaticPlates}
                />
                <label htmlFor="diplomatic_plates" data-cy="diplomatic_label">Diplomatic plates</label>
                <div aria-hidden={selected !== "diplomatic_plates"}>
                    <CountrySelect
                        countries={countriesForDiplomaticPlates}
                        value={diplomatic}
                        onChange={diplomaticPlates}
                        id="countries_diplomatic_list"
                        selectRef={diplomaticRef}
                    />
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
                                                onClick={handleGetDiplomaticPlatesByRegion}
                                                data-cy="get_diplomatic_plates_by_region_button">By region
                                        </button>
                                    </div>
                                    <br/>
                                    <input type="text" ref={getDiplomaticDescription} className="form-control ml-2"
                                           placeholder="Description" data-cy="get_by_diplomatic_description_input"/>
                                    <div className="input-group-append">
                                        <button className="btn btn-sm btn-primary" id='button4'
                                                onClick={handleGetDiplomaticPlatesByDescription}
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
                    onChange={(e) => setSelected(e.target.value)}
                    data-cy="upload_photo_radio_button"
                />
                <label htmlFor="upload_photo" data-cy="upload_photo_label">Upload Photo</label>
                <div aria-hidden={selected !== "upload_photo"}>
                    <h3 data-cy="upload_photo_h3_text">Upload photo with car plate</h3>
                    <div className="image-upload">
                        <label htmlFor="file-input">
                            <img src={upload} data-cy="upload_photo_image" alt="upload file"/>
                        </label>
                        <input id="file-input" type="file" onChange={(e) => setFile(e.target.files[0])}
                               data-cy="upload_photo"/>
                    </div>
                </div>
                <p className="logout-timer">
                    You will be logged out in <span className="timer"><Timer initialMinutes={2}
                                                                             initialSeconds={0}/></span>
                </p>
            </div> : <></>}
            {isShown && <LocationMarker/>}
        </div>
    );
}

export default App;
