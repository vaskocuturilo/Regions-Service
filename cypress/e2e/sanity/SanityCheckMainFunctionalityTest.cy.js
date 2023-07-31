/// <reference types ="cypress"/>

import {mainPage} from "../../support/pages/MainPage.cy"

describe('Testing main page for application regions', () => {
    beforeEach(() => {
        cy.visit('/')
    })

    it('Check main functionality for private plates by region', () => {
        mainPage.selectTypeOfPLates('Private plates');
        mainPage.addPrivateRegionPlates("poland", "WX");
    })

    it('Check main functionality for private plates by description', () => {
        mainPage.selectTypeOfPLates('Private plates');
        mainPage.addPrivateRegionPlates("poland", "WX");
        mainPage.addDescriptionPlates("poland", "Województwo mazowieckie, Warszawa-Żoliborz");
    })

    it('Check main functionality for diplomatic plates by region', () => {
        mainPage.selectTypeOfPLates('Diplomatic plates');
        mainPage.addDiplomaticRegionPlates("poland", "072180");
    })

    it('Check main functionality for diplomatic plates by region', () => {
        mainPage.selectTypeOfPLates('Diplomatic plates');
        mainPage.addDiplomaticDescriptionPlates("poland", "Serbia");
    })
})