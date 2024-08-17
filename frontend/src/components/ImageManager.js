class ImageManager {
    constructor() {
        this.countryImages = {
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
            "kosovo": "https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Kosovar_license_plate.svg/640px-Kosovar_license_plate.svg.png",
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

        this.diplomaticImages = {
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
    }

    getCountryImage(country) {
        return this.countryImages[country] || this.countryImages["None"];
    }

    getDiplomaticImage(country) {
        return this.diplomaticImages[country] || this.diplomaticImages["None"];
    }
}

export default ImageManager;
