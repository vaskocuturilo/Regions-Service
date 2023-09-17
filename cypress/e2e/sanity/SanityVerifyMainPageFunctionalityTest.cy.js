/// <reference types ="cypress"/>

import {mainPage} from "../../support/pages/MainPage.cy"

describe('Testing main page for application regions', () => {
    beforeEach(() => {
        cy.visit('/')
    })

    it('Check upload image functionality', () => {
        mainPage.clearModal();
        mainPage.selectTypeOfPLates('Upload Photo');
        mainPage.checkUploadImageFunctionality();
        mainPage.selectTypeOfPLates('Private plates');
        mainPage.checkThatMainImageVisibleCorrectly();
    })

    it('Check countries plates images with drop-down menu.', () => {
        mainPage.clearModal();
        mainPage.selectTypeOfPLates('Private plates');
        mainPage.checkImageByCountry('regionsFlags.json');
    })

     it.only('Check diplomatic countries plates images with drop-down menu.', () => {
        mainPage.clearModal();
        mainPage.selectTypeOfPLates('Diplomatic plates');
        mainPage.checkImageDiplomaticByCountry('diplomaticsFlags.json');
        })
    })