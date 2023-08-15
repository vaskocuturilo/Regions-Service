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

    it('Check main functionality for private plates by description', () => {
        mainPage.selectTypeOfPLates('Private plates');
        mainPage.addDescriptionPlates("armenia", "Yerevan (city)", "01");
        mainPage.addDescriptionPlates("austria", "Amstetten","AM");
        mainPage.addDescriptionPlates("azerbaijan", "Апшеронский район", "01");
        mainPage.addDescriptionPlates("belarus", "город Минск", "7");
        mainPage.addDescriptionPlates("british", "Anglia, Peterborough","AA");
        mainPage.addDescriptionPlates("bulgaria", "Burgas Province", "A");
        mainPage.addDescriptionPlates("croatia",  "Bjelovar, Čazma, Garešnica", "BJ");
        mainPage.addDescriptionPlates("czech", "Hlavní město Praha, Capital City Prague", "A");
        mainPage.addDescriptionPlates("estonia", "Tallinn", "A");
        mainPage.addDescriptionPlates("france", "Ain,LaonBourg-en-Bresse,Auvergne-Rhône-Alpes","01");
        mainPage.addDescriptionPlates("germany",  "Augsburg, Bavaria", "A");
        mainPage.addDescriptionPlates("greece", "Achaia prefecture - Patras", "AZ");
        mainPage.addDescriptionPlates("hungary",  "Sep 2021", "T");
        mainPage.addDescriptionPlates("ireland", "Cork", "C");
        mainPage.addDescriptionPlates("italian", "Agrigento","AG");
        mainPage.addDescriptionPlates("kazakhstan", "Нур-Султан", "01");
        mainPage.addDescriptionPlates("kosovo", "Pristina", "01");
        mainPage.addDescriptionPlates("kyrgyzstan", "Бишкек", "01");
        mainPage.addDescriptionPlates("lithuania",  "Klaipėda County", "L");
        mainPage.addDescriptionPlates("moldova",  "Tighina", "BE");
        mainPage.addDescriptionPlates("montenegro", "Berane", "BA");
        mainPage.addDescriptionPlates("norway",  "Drammen, Viken", "KE"); 
        mainPage.addDescriptionPlates("poland", "Województwo mazowieckie, Warszawa-Żoliborz", "WX");
        mainPage.addDescriptionPlates("romania", "Alba", "AB");
        mainPage.addDescriptionPlates("russia",  "Республика Адыгея", "01");
        mainPage.addDescriptionPlates("slovakia",  "Bratislava", "BA");
        mainPage.addDescriptionPlates("slovenia", "Brežice, Krško, Sevnica", "KK");
        mainPage.addDescriptionPlates("sweden",  "City of Stockholm", "AB");
        mainPage.addDescriptionPlates("switzerland",  "Bern", "BE");
        mainPage.addDescriptionPlates("turkey", "Afyonkarahisar", "03");
        mainPage.addDescriptionPlates("ukraine",  "Донецкая область","KH");
        mainPage.addDescriptionPlates("uzbekistan",  "город Ташкент", "02");
    })

    it('Check main functionality for diplomatic plates by region', () => {
        mainPage.selectTypeOfPLates('Diplomatic plates');
        mainPage.addDiplomaticDescriptionPlates("austria", "Vatican City", "1");
        mainPage.addDiplomaticDescriptionPlates("croatia", "Holy See", "010");
        mainPage.addDiplomaticDescriptionPlates("estonia",  "Sweden", "10");
        mainPage.addDiplomaticDescriptionPlates("france", "Algeria", "4");
        mainPage.addDiplomaticDescriptionPlates("germany",  "Egypt", "11");
        mainPage.addDiplomaticDescriptionPlates("italian",  "Cyprus","AM");
        mainPage.addDiplomaticDescriptionPlates("kyrgyzstan",  "China", "03");
        mainPage.addDiplomaticDescriptionPlates("lithuania", "Denmark", "05");
        mainPage.addDiplomaticDescriptionPlates("montenegro", "Turkey", "11");
        mainPage.addDiplomaticDescriptionPlates("norway",  "Belgium", "14");
        mainPage.addDiplomaticDescriptionPlates("norway",  "Belgium", "14");
        mainPage.addDiplomaticDescriptionPlates("poland", "Serbia", "072");
        mainPage.addDiplomaticDescriptionPlates("romania",  "Austria","105");
        mainPage.addDiplomaticDescriptionPlates("sweden",  "Albania", "AB");
        mainPage.addDiplomaticDescriptionPlates("switzerland", "Australia", "4");
    })
})