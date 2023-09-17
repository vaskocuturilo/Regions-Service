/// <reference types ="cypress"/>

import {mainPage} from "../../support/pages/MainPage.cy"

describe('Testing main page for application regions', () => {
    beforeEach(() => {
        cy.visit('/')
    })

    it('This is simple test for check main page', () => {
        mainPage.clearModal();
        mainPage.checkDefaultMainPageElementsAppears();
        mainPage.checkThatMainImageVisibleCorrectly();
        mainPage.checkAppearsPrivatePlatesBlock(); 
        mainPage.checkAppearsDiplomaticPlatesBlock();
        mainPage.checkAppearsUploadPhotoBlock();
        mainPage.checkAppearsPrivateCountriesInDropDown('flags/private.json');
        mainPage.checkAppearsDiplomaticCountriesInDropDown('flags/diplomatic.json')
        mainPage.checkAppearsNavBarMenu();
    })
}) 