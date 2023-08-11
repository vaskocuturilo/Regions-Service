/// <reference types ="cypress"/>

import {mainPage} from "../../support/pages/MainPage.cy"

describe('Testing main page for application regions', () => {
    beforeEach(() => {
        cy.visit('/')
    })

    it('Check alert message if user did not change any country', () => {
        mainPage.selectTypeOfPLates('Private plates');
        mainPage.tapByRegionButton('Choose any country first');
        mainPage.tapByDescriptionButton('Choose any country first');

        mainPage.selectTypeOfPLates('Diplomatic plates');
        mainPage.tapDiplomaticByRegionButton('Choose any country first');
        mainPage.tapDiplomaticByDescriptionButton('Choose any country first'); 
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