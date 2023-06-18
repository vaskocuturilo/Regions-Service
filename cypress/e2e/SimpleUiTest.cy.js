/// <reference types ="cypress"/>

import {mainPage} from "../support/pages/MainPage.cy"

describe('Testing main page for application regions', () => {
    beforeEach(() => {
        cy.visit('/')
    })

    it('This is simple test for check main page', () => {
        mainPage.checkMainPageElementsAppears();
        mainPage.checkAppersCountriesInDropDown();
        mainPage.checkUploadImageFunctionality();
        mainPage.checkImageByCountry("GB", "GB-license-plate-infographics-en.jpg");
        mainPage.checkImageDiplomaticByCountry("AU", "Austria");
        mainPage.checkImageDiplomaticByCountry("DE", "deutschland");
        mainPage.checkImageDiplomaticByCountry("PL", "poland-dyplomatyczn.png");
    })
}) 