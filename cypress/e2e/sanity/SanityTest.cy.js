/// <reference types ="cypress"/>

import {mainPage} from "../../support/pages/MainPage.cy"

describe('Testing main page for application regions', () => {
    beforeEach(() => {
        cy.visit('/')
    })

    it.only('Check upload image functionality', () => {
        mainPage.selectTypeOfPLates('Upload Photo');
        mainPage.checkUploadImageFunctionality();
    })

    it('Check countries plates images with drop-down menu.', () => {
        mainPage.selectTypeOfPLates('Private plates');
        mainPage.checkImageByCountry("armenia", "armenia");
        mainPage.checkImageByCountry("austria", "Austrian");
        mainPage.checkImageByCountry("azerbaijan", "Azerbaijan");
        mainPage.checkImageByCountry("belarus", "Belarus");
        mainPage.checkImageByCountry("british", "GB-license-plate-infographics-en.jpg");

        mainPage.checkImageByCountry("bulgaria", "Bulgaria");
        mainPage.checkImageByCountry("croatia", "Delnice_HR");
        mainPage.checkImageByCountry("czech", "license-plate-infographics-en.jpg");
        mainPage.checkImageByCountry("estonia", "Estonian");
        mainPage.checkImageByCountry("france", "France");
        mainPage.checkImageByCountry("germany", "germany");
        mainPage.checkImageByCountry("greece", "Greek");
        mainPage.checkImageByCountry("hungary", "Hungarian");
        mainPage.checkImageByCountry("ireland", "Ireland");
        mainPage.checkImageByCountry("italy", "Italy");
        mainPage.checkImageByCountry("kazakhstan", "Kazakhstan");
        mainPage.checkImageByCountry("kosovo", "Kosovo");
        mainPage.checkImageByCountry("kyrgyzstan", "KG");
        mainPage.checkImageByCountry("lithuania", "Lithuania");
        mainPage.checkImageByCountry("moldova", "Moldova");
        mainPage.checkImageByCountry("montenegro", "Montenegro");
        mainPage.checkImageByCountry("norway", "Skilt_elbil");
        mainPage.checkImageByCountry("poland", "poland");
        mainPage.checkImageByCountry("romania", "Romanian");
        mainPage.checkImageByCountry("russia", "Russian");
        mainPage.checkImageByCountry("slovakia", "Slovak");
        mainPage.checkImageByCountry("slovenia", "Tablica_KR_-_Kranj");
        mainPage.checkImageByCountry("sweden", "Sweden");
        mainPage.checkImageByCountry("switzerland", "switzerland");
        mainPage.checkImageByCountry("turkey", "Turkey");
        mainPage.checkImageByCountry("ukraine", "Ukraine");
        mainPage.checkImageByCountry("uzbekistan", "Uzbekistan");   
    })

     it('Check diplomatic countries plates images with drop-down menu.', () => {
        mainPage.selectTypeOfPLates('Diplomatic plates');
        mainPage.checkImageDiplomaticByCountry("austria", "Austria");
        mainPage.checkImageDiplomaticByCountry("germany", "deutschland");
        mainPage.checkImageDiplomaticByCountry("poland", "poland-dyplomatic.png");
        mainPage.checkImageDiplomaticByCountry("croatia", "kroatie36.jpg");
        mainPage.checkImageDiplomaticByCountry("estonia", "Estonia_diplomatic");
        mainPage.checkImageDiplomaticByCountry("france", "French_diplomatic_license");
        mainPage.checkImageDiplomaticByCountry("italy", "Targa_automobilistica_Italia");
        mainPage.checkImageDiplomaticByCountry("kyrgyzstan", "Kyrgyzstan_diplomatic");
        mainPage.checkImageDiplomaticByCountry("lithuania", "Lithuanian_diplomatic_license_plate");
        mainPage.checkImageDiplomaticByCountry("montenegro", "Montenegro_diplomatic_license_plate");
        mainPage.checkImageDiplomaticByCountry("norway", "Norway_diplomatic_license");
        mainPage.checkImageDiplomaticByCountry("romania", "Romania_diplomatic_number");
        mainPage.checkImageDiplomaticByCountry("sweden", "Sweden_diplomatic_license_plate");
        mainPage.checkImageDiplomaticByCountry("switzerland", "Switzerland_CD_Diplomatic_license_plate");
        })
    })