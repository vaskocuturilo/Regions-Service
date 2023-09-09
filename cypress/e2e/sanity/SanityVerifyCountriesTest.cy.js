/// <reference types ="cypress"/>

import {mainPage} from "../../support/pages/MainPage.cy"

describe('Checking all countries. ', () => {
    beforeEach(() => {
        cy.visit('/')
    })


    it('Check all regions and desriptions for private plates', () => {
        mainPage.selectTypeOfPLates('Private plates');
        mainPage.addPrivateRegionPlates('regions.json');
    })

    it('Check all regions and desriptions for diplomatic plates', () => {
        mainPage.selectTypeOfPLates('Diplomatic plates');
        mainPage.addDiplomaticRegionPlates('diplomatic.json');
    })
})