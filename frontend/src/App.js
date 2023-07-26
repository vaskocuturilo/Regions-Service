import './App.css';
import React, { useRef, useState } from "react";
import apiClient from "./http-common";
import logo from './img/upload.png'

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
    "italy": "https://cdn.skoda-storyboard.com/2019/06/Italy-license-plate-english.jpg",
    "kazakhstan": "https://upload.wikimedia.org/wikipedia/commons/f/fe/License_plate_Kazakhstan_2012.png",
    "kosovo": "https://upload.wikimedia.org/wikipedia/en/thumb/a/a9/Kosovo_car_registration_plate_labels.svg/320px-Kosovo_car_registration_plate_labels.svg.png",
    "kyrgyzstan": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Plak_shakhsi-KG.png/800px-Plak_shakhsi-KG.png",
    "lithuania": "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Lithuanian_license_plate.svg/1280px-Lithuanian_license_plate.svg.png",
    "moldova": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Moldova_MD_license_plate_ABC012_2015.svg/1024px-Moldova_MD_license_plate_ABC012_2015.svg.png",
    "montenegro": "https://upload.wikimedia.org/wikipedia/commons/f/f6/License_plate_Montenegro.jpg",
    "norway": "https://upload.wikimedia.org/wikipedia/commons/3/33/Skilt_elbil.jpg",
    "poland": "https://cdn.skoda-storyboard.com/2019/08/poland-number-plates-infographics-english-1920x1288.jpg",
    "romania": "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Romanian_license_plate.svg/1024px-Romanian_license_plate.svg.png",
    "russia": "https://cdn.skoda-storyboard.com/2019/04/Russian-license-plate-english.jpg",
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
  "poland": "./img/poland-dyplomatyczn.png",
  "croatia": "https://licenseplatemania.com/fotos/kroatie/kroatie36.jpg",
  "estonia": "https://upload.wikimedia.org/wikipedia/commons/3/3c/Estonia_diplomatic_license_plate_CD_European_standard.jpg",
  "france": "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/French_diplomatic_license_plate.jpg/1024px-French_diplomatic_license_plate.jpg",
  "italy": "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Targa_automobilistica_Italia_1985_CD%E2%80%A20213%E2%80%A2XG_Corpo_Diplomatico_Citt%C3%A0_del_Vaticano.jpg/1024px-Targa_automobilistica_Italia_1985_CD%E2%80%A20213%E2%80%A2XG_Corpo_Diplomatico_Citt%C3%A0_del_Vaticano.jpg",
  "kyrgyzstan": "https://upload.wikimedia.org/wikipedia/commons/3/38/Kyrgyzstan_diplomatic_technical_staff_license_plate.png",
  "lithuania": "https://upload.wikimedia.org/wikipedia/commons/8/8e/Lithuanian_diplomatic_license_plate.JPG?20120714185557",
  "montenegro": "https://upload.wikimedia.org/wikipedia/commons/0/08/Montenegro_diplomatic_license_plate_%28Norway%29.jpg",
  "norway": "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Norway_diplomatic_license_plate_CD_48160_2014_Oslo.jpg/1280px-Norway_diplomatic_license_plate_CD_48160_2014_Oslo.jpg",
  "romania": "https://upload.wikimedia.org/wikipedia/commons/c/c1/Romania_diplomatic_number_plate_CD_205_113.jpg",
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

  const get_by_region = useRef(null);
  const get_by_description = useRef(null);

  const get_by_diplomatic_region = useRef(null);
  const get_by_diplomatic_description = useRef(null);

  const [getResult, setGetResult] = useState(null);
  const [plates, setPlates] = useState(getInitialStateSimplePlates);
  const [diplomatic, setDiplomatic] = useState(getInitialStateDiplomaticPlates);
  const ref = useRef(null); 
  const dip = useRef(null); 

  const fortmatResponse = (res) => {
    return JSON.stringify(res, null, 2);
  };

  async function getPlatesByRegion() {
    const region = get_by_region.current.value;

    if (region) {
      try {
        const res = await apiClient.get(`/${plates}/plates/region/${region}`);

        const result = {
          data: res.data,
          status: res.status,
          statusText: res.statusText,
          headers: res.headers,
        };

        setGetResult(fortmatResponse(result));
      } catch (err) {
        if (!err?.response) {
          alert("No Server Response");
          return;
       }
        setGetResult(fortmatResponse(err.response?.data || err));
      }
    }
  }

  async function getDiplomaticPlatesByRegion() {
    const region = get_by_diplomatic_region.current.value;

    if (region) {
      try {
        const res = await apiClient.get(`/${diplomatic}/diplomatic/plates/region/${region}`);

        const result = {
          data: res.data,
          status: res.status,
          statusText: res.statusText,
          headers: res.headers,
        };

        setGetResult(fortmatResponse(result));
      } catch (err) {
        if (!err?.response) {
          alert("No Server Response");
          return;
       }
        setGetResult(fortmatResponse(err.response?.data || err));
      }
    }
  }

  async function getPlatesByDescription() {
    const description = get_by_description.current.value;

    if (description) {
      try {
        const res = await apiClient.get(`/${plates}/plates/description/${description}`);

        const result = {
          data: res.data,
          status: res.status,
          statusText: res.statusText,
          headers: res.headers,
        };

        setGetResult(fortmatResponse(result));
      } catch (err) {
        if (!err?.response) {
          alert("No Server Response");
          return;
       }
        setGetResult(fortmatResponse(err.response?.data || err));
      }
    }
  }

  async function getDiplomaticPlatesByDescription() {
    const description = get_by_diplomatic_description.current.value;

    if (description) {
      try {
        const res = await apiClient.get(`/${diplomatic}/diplomatic/plates/description/${description}`);

        const result = {
          data: res.data,
          status: res.status,
          statusText: res.statusText,
          headers: res.headers,
        };

        setGetResult(fortmatResponse(result));
      } catch (err) {
        if (!err?.response) {
          alert("No Server Response");
          return;
       }
        setGetResult(fortmatResponse(err.response?.data || err));
      }
    }
  }

  const clearGetOutput = () => {
    setGetResult(null);
  };

  const simplePlates = (e) => {
    const element = ref.current;
    document.getElementById('countries_image').src = countryImages[element.value];
    setPlates(e.target.value);
  };

  const diplomaticPlates = (e) => {
    const element = dip.current;
    document.getElementById('countries_image').src = diplomaticImages[element.value];
    setDiplomatic(e.target.value);
  };

  window.addEventListener('load', function () {
    document.querySelector('input[type="file"]').addEventListener('change', function () {
        if (this?.files && this?.files[0]) {
            let img = document.querySelector('img');
            img.onload = () => {
                URL.revokeObjectURL(img.src);
            }
            img.src = URL.createObjectURL(this.files[0]);
        }
    });
});

  return (
    <div className="App">
      <div>
    <nav role='navigation'>
        <div id="menuToggle">
            <input type="checkbox"/>
            <span></span>
            <span></span>
            <span></span>
            <ul id="menu">
                <a href="/logout">
                    <li>Logout</li>
                </a>
                <a href="/api/v1/users/all">
                    <li>Admin</li>
                </a>
            </ul>
        </div>
    </nav>
</div>
      <img id="countries_image"
                     src="https://media.istockphoto.com/id/1154067988/vector/colorful-hand-drawn-vector-map-of-europe-with-countries-names-doodle-style.jpg?s=612x612&w=0&k=20&c=u10GKRTIjHyhwumg3_eArjO4lGL3xFyHsa3N8luTYXA="
                     class="center"/>
      <div class="col-lg-12 login-title">
      <div role="alert" class="center alert alert-info mt-2"> Please choose any country first </div>
                <p class="center">Plates:</p>
                <select value= {plates} name="countries_plates" id="countries_list"
                        onChange={simplePlates}
                        class="form__input center" ref={ref} data-cy="countries_drop_down">
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
                    <option value="italy">🇮🇹&emsp;Italy</option>
                    <option value="kazakhstan">🇰🇿&emsp;Kazakhstan</option>
                    <option value="kosovo">🇽🇰&emsp;Kosovo</option>
                    <option value="kyrgyzstan">🇰🇬&emsp;Kyrgyzstan</option>
                    <option value="lithuania">🇱🇹&emsp;Lithuania</option>
                    <option value="moldova">🇲🇩&emsp;Moldova</option>
                    <option value="montenegro">🇲🇪&emsp;Montenegro</option>
                    <option value="norway">🇳🇴&emsp;Norway</option>
                    <option value="poland">🇵🇱&emsp;Poland</option>
                    <option value="romania">🇷🇴&emsp;Romania</option>
                    <option value="russia">🇷🇺&emsp;Russia</option>
                    <option value="slovakia">🇸🇰&emsp;Slovakia</option>
                    <option value="slovenia">🇸🇮&emsp;Slovenia</option>
                    <option value="sweden">🇸🇪&emsp;Sweden</option>
                    <option value="switzerland">🇨🇭&emsp;Switzerland</option>
                    <option value="turkey">🇹🇷&emsp;Turkey</option>
                    <option value="ukraine">🇺🇦&emsp;Ukraine</option>
                    <option value="uzbekistan">🇺🇿&emsp;Uzbekistan</option>
                </select>
            </div>
            <p class="center">Diplomatic plates:</p>
            <select value= {diplomatic} name="diplomatic_plates" id="countries_diplomatic_list"
            onChange={diplomaticPlates}
                    class="form__input center" ref={dip} data-cy="diplomatic_drop_down">
                <option value="None">Choose country</option>
                <option value="austria">🇦🇹&emsp;Austria</option>
                <option value="germany">🇩🇪&emsp;Germany</option>
                <option value="poland">🇵🇱&emsp;Poland</option>
                <option value="croatia">🇭🇷&emsp;Croatia</option>
                <option value="estonia">🇪🇪&emsp;Estonia</option>
                <option value="france">🇫🇷&emsp;France</option>
                <option value="italy">🇮🇹&emsp;Italy</option>
                <option value="kyrgyzstan">🇰🇬&emsp;Kyrgyzstan</option>
                <option value="lithuania">🇱🇹&emsp;Lithuania</option>
                <option value="montenegro">🇲🇪&emsp;Montenegro</option>
                <option value="norway">🇳🇴&emsp;Norway</option>
                <option value="romania">🇷🇴&emsp;Romania</option>
                <option value="sweden">🇸🇪&emsp;Sweden</option>
                <option value="switzerland">🇨🇭&emsp;Switzerland</option>
            </select>
            <br/>
            <br/>
            <br/>
      <div id="app" className="container">
      <div className="card">
      <div className="card-header">Plates:</div>
        <div className="card-body">
          <div className="input-group input-group-sm">
            <input type="text" ref={get_by_region} className="form-control ml-2" placeholder="Region" data-cy="region_plates_input"/>

            <div className="input-group-append">
              <button className="btn btn-sm btn-primary" disabled = "disabled" onClick={getPlatesByRegion} data-cy="get_plates_by_region_button">By Region</button>
              </div>
      
            <input type="text" ref={get_by_description} className="form-control ml-2" placeholder="Description" data-cy="description_plates_input"/>
            
            <div className="input-group-append">
              <button className="btn btn-sm btn-primary" disabled = "disabled" onClick={getPlatesByDescription} data-cy="get_plates_by_description_button">By description</button>
            </div>
            
          </div>   
        </div>
        <button className="btn btn-primary" onClick={clearGetOutput} data-cy="clear_button">Clear</button>
      </div>
      { getResult && <div className="alert alert-secondary mt-2" role="alert"><pre>{getResult}</pre></div> }
    <br/>
    <br/>
    <div className="card">
    <div className="card-header">Diplomatic plates:</div>
        <div className="card-body">
          <div className="input-group input-group-sm">
            <input type="text" ref={get_by_diplomatic_region} className="form-control ml-2" placeholder="Region" data-cy="region_diplomatic_plates_input"/>
            <br/>
            <div className="input-group-append">
              <button className="btn btn-sm btn-primary" disabled = "disabled" onClick={getDiplomaticPlatesByRegion} data-cy="get_diplomatic_plates_by_region_button">By region</button>
            </div>
            <br/>
            <input type="text" ref={get_by_diplomatic_description} className="form-control ml-2" placeholder="Description" data-cy="get_by_diplomatic_description_input"/>
            <div className="input-group-append">
              <button className="btn btn-sm btn-primary" disabled = "disabled" onClick={getDiplomaticPlatesByDescription} data-cy="get_diplomatic_plates_by_description">By description</button>
            </div>
            <br/>
          </div>   
        </div>
        <button className="btn btn-primary" onClick={clearGetOutput} data-cy="clear_button">Clear</button>
      </div>
      { getResult && <div className="alert alert-info mt-2" role="alert"><pre>{getResult}</pre></div> }
    </div>
    <h3>Upload photo with car plate</h3>
 <div class="image-upload">
    <label for="file-input">
    <img src={logo} alt={"logo"}/> 
    </label>
    <input id="file-input" type="file"/>
     </div>    
 </div>
 );
}

export default App;
