/// <reference types ="cypress"/>

import {mainPage} from "../support/pages/MainPage.cy"

describe('Testing main page for application regions', () => {
    beforeEach(() => {
        cy.visit('/')
    })

    it('This is simple test for check main page', () => {
        mainPage.checkMainPageElementsAppears();
        mainPage.checkAppearsCountriesInDropDown();
        mainPage.checkUploadImageFunctionality();
        mainPage.checkImageByCountry("GB", "GB-license-plate-infographics-en.jpg");
        mainPage.checkImageDiplomaticByCountry("AU", "Austria");
        mainPage.checkImageDiplomaticByCountry("DE", "deutschland");
        mainPage.checkImageDiplomaticByCountry("PL", "poland-dyplomatyczn.png");
        mainPage.checkImageDiplomaticByCountry("HR", "kroatie36.jpg");
        mainPage.checkImageDiplomaticByCountry("EE", "Estonia_diplomatic");
        mainPage.checkImageDiplomaticByCountry("FR", "French_diplomatic_license");
        mainPage.checkImageDiplomaticByCountry("IT", "Targa_automobilistica_Italia");
        mainPage.checkImageDiplomaticByCountry("KG", "Kyrgyzstan_diplomatic");
        mainPage.checkImageDiplomaticByCountry("LT", "Lithuanian_diplomatic_license_plate");
        mainPage.checkImageDiplomaticByCountry("ME", "Montenegro_diplomatic_license_plate");
        mainPage.checkImageDiplomaticByCountry("NO", "Norway_diplomatic_license");
        mainPage.checkImageDiplomaticByCountry("RO", "Romania_diplomatic_number");
        mainPage.checkImageDiplomaticByCountry("SE", "Sweden_diplomatic_license_plate");
        mainPage.checkImageDiplomaticByCountry("CH", "Switzerland_CD_Diplomatic_license_plate");

    })
}) 