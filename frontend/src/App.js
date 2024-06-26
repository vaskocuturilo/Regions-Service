import './App.css';
import React, { useRef, useState, useEffect } from "react";
import apiClient from "./http-common";
import upload from './img/upload.png';
import logo from './img/europe-plates.jpg';
import $ from 'jquery';
import JSONPretty from 'react-json-pretty';
import { createWorker } from "tesseract.js";
import 'bootstrap/dist/css/bootstrap.css';
import Header from './components/Header';
import Popup from './components/Popup';
import '@popperjs/core';
import LocationMarker from './components/MapView';

function App() {

  let countryImages = {
    "None": "https://media.istockphoto.com/id/1154067988/vector/colorful-hand-drawn-vector-map-of-europe-with-countries-names-doodle-style.jpg?s=612x612&w=0&k=20&c=u10GKRTIjHyhwumg3_eArjO4lGL3xFyHsa3N8luTYXA=",
    "armenia": "https://www.plateshack.com/y2k/Armenia/armenia21sc221.jpg",
    "austria": "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Austrian_license_plate.svg/1280px-Austrian_license_plate.svg.png",
    "azerbaijan": "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Azerbaijan_licence_plate_format.svg/1024px-Azerbaijan_licence_plate_format.svg.png",
    "belarus": "https://upload.wikimedia.org/wikipedia/commons/7/78/Belarus_license_plate.png",
    "british": "https://cdn.skoda-storyboard.com/2019/01/GB-license-plate-infographics-en.jpg",
    "bulgaria": "https://upload.wikimedia.org/wikipedia/commons/0/0b/Bulgaria-automobile-license-plate.png",
    "croatia": "https://upload.wikimedia.org/wikipedia/commons/thumb/6/68/Registarska_plo%C4%8Dica_Delnice_HR_%282016-%29.jpg/1920px-Registarska_plo%C4%8Dica_Delnice_HR_%282016-%29.jpg",
    "czech": "https://cdn.skoda-storyboard.com/2019/01/license-plate-infographics-en.jpg",
    "estonia": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Estonian_license_plate.svg/1280px-Estonian_license_plate.svg.png",
    "france": "https://cdn.skoda-storyboard.com/2019/07/France-license-plate-english.jpg",
    "germany": "https://cdn.skoda-storyboard.com/2019/04/germany-license-plate-english-infographic.jpg",
    "greece": "https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/Greek_license_plate.svg/1280px-Greek_license_plate.svg.png",
    "hungary": "https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Hungarian_license_plate.svg/1280px-Hungarian_license_plate.svg.png",
    "ireland": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Revised_format_Republic_of_Ireland_numberplate_%282013-%29.svg/1920px-Revised_format_Republic_of_Ireland_numberplate_%282013-%29.svg.png",
    "italian": "https://cdn.skoda-storyboard.com/2019/06/Italy-license-plate-english.jpg",
    "kazakhstan": "https://upload.wikimedia.org/wikipedia/commons/f/fe/License_plate_Kazakhstan_2012.png",
    "kosovo": "https://upload.wikimedia.org/wikipedia/en/thumb/a/a9/Kosovo_car_registration_plate_labels.svg/320px-Kosovo_car_registration_plate_labels.svg.png",
    "kyrgyzstan": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Plak_shakhsi-KG.png/800px-Plak_shakhsi-KG.png",
    "lithuania": "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Lithuanian_license_plate.svg/1280px-Lithuanian_license_plate.svg.png",
    "malaysia": "https://en.m.wikipedia.org/wiki/Vehicle_registration_plates_of_Malaysia#/media/File%3AMalaysia_penang_license_plate_front.JPG",
    "moldova": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Moldova_MD_license_plate_ABC012_2015.svg/1024px-Moldova_MD_license_plate_ABC012_2015.svg.png",
    "montenegro": "https://upload.wikimedia.org/wikipedia/commons/f/f6/License_plate_Montenegro.jpg",
    "norway": "https://upload.wikimedia.org/wikipedia/commons/3/33/Skilt_elbil.jpg",
    "macedonia": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c0/North_Macedonia_plate_2019.jpg/1024px-North_Macedonia_plate_2019.jpg",
    "poland": "https://cdn.skoda-storyboard.com/2019/08/poland-number-plates-infographics-english-1920x1288.jpg",
    "romania": "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Romanian_license_plate.svg/1024px-Romanian_license_plate.svg.png",
    "russia": "https://cdn.skoda-storyboard.com/2019/04/Russian-license-plate-english.jpg",
    "serbia": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/License_plate_of_Serbia%2C_2014.JPG/1024px-License_plate_of_Serbia%2C_2014.JPG",
    "slovakia": "https://upload.wikimedia.org/wikipedia/commons/1/1d/Slovak_car_registration_plate_2023.jpg",
    "slovenia": "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Tablica_KR_-_Kranj.jpg/1920px-Tablica_KR_-_Kranj.jpg",
    "sweden": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/80/Sweden_licenseplate_EU.JPG/1920px-Sweden_licenseplate_EU.JPG",
    "switzerland": "https://cdn.skoda-storyboard.com/2019/10/switzerland-number-plate-english-1920x1751.jpg",
    "turkey": "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Foreigners_with_temporary_residence_permit_vehicle_license_plate_of_Turkey.svg/1024px-Foreigners_with_temporary_residence_permit_vehicle_license_plate_of_Turkey.svg.png",
    "ukraine": "https://upload.wikimedia.org/wikipedia/commons/7/77/License_plate_of_Ukraine_2015.png",
    "uzbekistan": "https://upload.wikimedia.org/wikipedia/commons/a/a9/Uzbekistan_2008_passenger_license_plate_legend.png"
  };

let diplomaticImages = {
  "None": "https://media.istockphoto.com/id/1154067988/vector/colorful-hand-drawn-vector-map-of-europe-with-countries-names-doodle-style.jpg?s=612x612&w=0&k=20&c=u10GKRTIjHyhwumg3_eArjO4lGL3xFyHsa3N8luTYXA=",
  "austria": "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/Austria_diplomatic_license_plate_WD-14021.jpg/1024px-Austria_diplomatic_license_plate_WD-14021.jpg",
  "germany": "https://www.tuningblog.eu/wp-content/uploads/2020/07/diplomatenkennzeichen-deutschland-17-CD-147-1.jpg",
  "poland": "https://i.postimg.cc/gjby4VRr/poland-dyplomatic.png",
  "croatia": "https://licenseplatemania.com/fotos/kroatie/kroatie36.jpg",
  "estonia": "https://upload.wikimedia.org/wikipedia/commons/3/3c/Estonia_diplomatic_license_plate_CD_European_standard.jpg",
  "france": "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/French_diplomatic_license_plate.jpg/1024px-French_diplomatic_license_plate.jpg",
  "italian": "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Targa_automobilistica_Italia_1985_CD%E2%80%A20213%E2%80%A2XG_Corpo_Diplomatico_Citt%C3%A0_del_Vaticano.jpg/1024px-Targa_automobilistica_Italia_1985_CD%E2%80%A20213%E2%80%A2XG_Corpo_Diplomatico_Citt%C3%A0_del_Vaticano.jpg",
  "kyrgyzstan": "https://upload.wikimedia.org/wikipedia/commons/3/38/Kyrgyzstan_diplomatic_technical_staff_license_plate.png",
  "lithuania": "https://upload.wikimedia.org/wikipedia/commons/8/8e/Lithuanian_diplomatic_license_plate.JPG?20120714185557",
  "malaysia": "https://en.wikipedia.org/wiki/Vehicle_registration_plates_of_Malaysia#/media/File:Diplomat_Plate_Number.jpg",
  "montenegro": "https://upload.wikimedia.org/wikipedia/commons/0/08/Montenegro_diplomatic_license_plate_%28Norway%29.jpg",
  "norway": "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Norway_diplomatic_license_plate_CD_48160_2014_Oslo.jpg/1280px-Norway_diplomatic_license_plate_CD_48160_2014_Oslo.jpg",
  "portugal": "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Portugal_diplomatic_license_plate_200-CD530.jpg/800px-Portugal_diplomatic_license_plate_200-CD530.jpg",
  "romania": "https://upload.wikimedia.org/wikipedia/commons/c/c1/Romania_diplomatic_number_plate_CD_205_113.jpg",
  "russia": "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Russian_diplomatic_license_plate_014_D_161.jpg/640px-Russian_diplomatic_license_plate_014_D_161.jpg",
  "sweden": "https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Sweden_diplomatic_license_plate_DL004B.jpg/1024px-Sweden_diplomatic_license_plate_DL004B.jpg",
  "switzerland": "https://upload.wikimedia.org/wikipedia/commons/2/22/Switzerland_CD_Diplomatic_license_plate_GE_29%E2%80%A2201.jpg"
  };
  const getInitialStateSimplePlates = () => {
    const plates = "Choose country";
    return plates;
  };

  const getInitialStateDiplomaticPlates = () => {
    const diplomatic = "Choose country";
    return diplomatic;
  };

  const getRegion = useRef(null);
  const getDescription = useRef(null);
  const image = useRef(null);

  const getDiplomaticRegion = useRef(null);
  const getDiplomaticDescription = useRef(null);

  const [getResult, setGetResult] = useState(null);
  const [plates, setPlates] = useState(getInitialStateSimplePlates);
  const [diplomatic, setDiplomatic] = useState(getInitialStateDiplomaticPlates);
  const regionRef = useRef(null); 
  const diplomaticRef = useRef(null);

  const typePlates = useRef(null);
  
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

  const fortmatResponse = (res) => {
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
        
        setGetResult(fortmatResponse(result));
        getRegion.current.value = '';
        setIsShown(true);
      } catch (err) {
        if (!err?.response) {
          alert("No Server Response");
          return;
       }
        setGetResult(fortmatResponse(err.response?.data || err));
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

        setGetResult(fortmatResponse(result));
        getDiplomaticRegion.current.value = '';
        setIsShown(true);
      } catch (err) {
        if (!err?.response) {
          alert("No Server Response");
          return;
       }
        setGetResult(fortmatResponse(err.response?.data || err));
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

        setGetResult(fortmatResponse(result));
        getDescription.current.value = '';
        setIsShown(true);
      } catch (err) {
        if (!err?.response) {
          alert("No Server Response");
          return;
       }
        setGetResult(fortmatResponse(err.response?.data || err));
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

        setGetResult(fortmatResponse(result));
        getDiplomaticDescription.current.value = '';
        setIsShown(true);
      } catch (err) {
        if (!err?.response) {
          alert("No Server Response");
          return;
       }
        setGetResult(fortmatResponse(err.response?.data || err));
        getDiplomaticDescription.current.value = '';
      }
    }
  }

  const clearGetOutputPrivatePlates = () => {
    setFile('');
    image.current.src = logo;
    setGetResult(null);
    setPlates('');
    getRegion.current.value = '';
    getDescription.current.value = '';
    typePlates.current.classList.remove('hidden');
    setIsShown(false);
  };

  const clearGetOutputDiplomaticlates = () => {
    setFile('');
    image.current.src = logo;
    setGetResult(null);
    setDiplomatic('');
    getDiplomaticRegion.current.value = '';
    getDiplomaticDescription.current.value = '';
    typePlates.current.classList.remove('hidden');
    setIsShown(false);
  };

  const simplePlates = (e) => {
    const element = regionRef.current;
    document.getElementById('countries_image').src = countryImages[element.value];
    setPlates(e.target.value);
    typePlates.current.classList.add('hidden');
  };

  const diplomaticPlates = (e) => {
    const element = diplomaticRef.current;
    document.getElementById('countries_image').src = diplomaticImages[element.value];
    setDiplomatic(e.target.value);
    typePlates.current.classList.add('hidden');
  };

$(document).on("change", "#countries_list", function(e){
  $('#countries_diplomatic_list').val('None');
});

$(document).on("change", "#countries_diplomatic_list", function(e){
    $('#countries_list').val('None');
});

const convertImageToText = async () => {
    if (!imageData) return;
    const worker = await createWorker();
    await worker.load();  
    await worker.loadLanguage('eng');
    await worker.initialize('eng');
    const {
      data: { text },
    } = await worker.recognize(imageData);
    setOcr(text);
    console.log(`This is result: ${text}`);
    await worker.terminate();
  };

  function handleImageChange(e) {
    const file = e.target.files[0];
    if(!file)return;
    const reader = new FileReader();
    reader.onloadend = () => {
      const imageDataUri = reader.result;
      console.log({ imageDataUri });
      setImageData(imageDataUri);
    };
    reader.readAsDataURL(file);
  }

  useEffect(() => {
    convertImageToText();
  }, [imageData]);

  const [showElement,setShowElement] = React.useState(true)
  useEffect(()=>{
    setTimeout(function() {
      setShowElement(false);
      image.current.src = logo;
         }, 120000);
       },
   []);

  function updateTime() {
    if (minutes == 0 && seconds == 0) {
      //reset
      setSeconds(0);
      setMinutes(5);
    }
    else {
      if (seconds == 0) {
        setMinutes(minutes => minutes - 1);
        setSeconds(59);
      } else {
        setSeconds(seconds => seconds - 1);
      }
    }
  }

  useEffect(() => {
    // use set timeout and be confident because updateTime will cause rerender
    // rerender mean re call this effect => then it will be similar to how setinterval works
    // but with easy to understand logic
    const token = setTimeout(updateTime, 1000)

    return function cleanUp() {
      clearTimeout(token);
    }
  });

return (
    <div className="App">
       <Header></Header>
       <Popup></Popup>
      <img id="countries_image" src={file ? URL.createObjectURL(file) : logo} ref={image} alt="this is main image" className='center'/>
      {showElement?<div>  
      <div class="center alert alert-info mt-2" data-cy="alert_message_block" ref={typePlates}>Please choose any type of plates</div>
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
      <div aria-hidden={selected !== "private_plates" ? true : false}>
        <select value={plates} name="countries_plates" id="countries_list"
                onChange={simplePlates}
                class="form__input center" ref={regionRef} data-cy="countries_drop_down">
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
            <input type="text" ref={getRegion} className="form-control ml-2" placeholder="Region" data-cy="region_plates_input"/>
            <div className="input-group-append">
              <button className="btn btn-sm btn-primary" id='button1' onClick={getPlatesByRegion} data-cy="get_plates_by_region_button">By region</button>
              </div>
            <input type="text" ref={getDescription} className="form-control ml-2" placeholder="Description" data-cy="description_plates_input"/>
            
            <div className="input-group-append">
              <button className="btn btn-sm btn-primary" id='button2' onClick={getPlatesByDescription} data-cy="get_plates_by_description_button">By description</button>
            </div>
          </div>
          <JSONPretty id="json-pretty" style={{fontSize: "1.1em", textAlign: 'left'}} data={getResult} mainStyle="padding:1em" valueStyle="font-size:1.5em"></JSONPretty>   
        </div>
        <button className="btn btn-primary" onClick={clearGetOutputPrivatePlates} data-cy="clear_button">Clear</button>
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
        onClick={clearGetOutputDiplomaticlates}
      />
      <label htmlFor="diplomatic_plates" data-cy="diplomatic_label">Diplomatic plates</label>
      <div aria-hidden={selected !== "diplomatic_plates" ? true : false}>
        <select value={diplomatic} name="diplomatic_plates" id="countries_diplomatic_list"
                onChange={diplomaticPlates}
                class="form__input center" ref={diplomaticRef} data-cy="diplomatic_drop_down">
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
            <input type="text" ref={getDiplomaticRegion} className="form-control ml-2" placeholder="Region" data-cy="region_diplomatic_plates_input"/>
            <br/>
            <div className="input-group-append">
              <button className="btn btn-sm btn-primary" id='button3' onClick={getDiplomaticPlatesByRegion} data-cy="get_diplomatic_plates_by_region_button">By region</button>
            </div>
            <br/>
            <input type="text" ref={getDiplomaticDescription} className="form-control ml-2" placeholder="Description" data-cy="get_by_diplomatic_description_input"/>
            <div className="input-group-append">
              <button className="btn btn-sm btn-primary" id='button4' onClick={getDiplomaticPlatesByDescription} data-cy="get_diplomatic_plates_by_description">By description</button>
            </div>
            <br/>
          </div>   
          <JSONPretty id="json-pretty" style={{fontSize: "1.1em", textAlign: 'left'}} data={getResult} mainStyle="padding:1em" valueStyle="font-size:1.5em"></JSONPretty>   
        </div>
        <button className="btn btn-primary" onClick={clearGetOutputDiplomaticlates} data-cy="clear_button">Clear</button>
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
      <div aria-hidden={selected !== "upload_photo" ? true : false}>
      <h3 data-cy="upload_photo_h3_text">Upload photo with car plate</h3>
    <div class="image-upload">
       <label for="file-input">
      <img src={upload} data-cy="upload_photo_image"/> 
       </label>
    <input id="file-input" type="file" onChange={(e) => setFile(e.target.files[0])} data-cy="upload_photo"/>
     </div>    
    </div>
    <p class="logout-timer">
        You will be logged out in <span class="timer">time: {minutes}:{seconds}</span>
      </p> 
    </div>:<></>}
    {isShown && <LocationMarker />}
  </div>
 );
}

export default App;
