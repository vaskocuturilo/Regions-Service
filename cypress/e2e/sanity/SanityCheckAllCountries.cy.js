/// <reference types ="cypress"/>

import {mainPage} from "../../support/pages/MainPage.cy"

describe('Checking all countries. ', () => {
    beforeEach(() => {
        cy.visit('/')
    })


    it('Check all regions and desriptions for private plates', () => {
        mainPage.selectTypeOfPLates('Private plates');
        mainPage.addPrivateRegionPlates("armenia", "01", "Yerevan (city)");
        mainPage.addPrivateRegionPlates("austria", "AM", "Amstetten");
        mainPage.addPrivateRegionPlates("azerbaijan", "01", "Апшеронский район");
        mainPage.addPrivateRegionPlates("belarus", "7", "город Минск");
        mainPage.addPrivateRegionPlates("british", "AA67", "Anglia, Peterborough");
        mainPage.addPrivateRegionPlates("bulgaria", "A", "Burgas Province");
        mainPage.addPrivateRegionPlates("croatia", "BJ", "Bjelovar, Čazma, Garešnica");
        mainPage.addPrivateRegionPlates("czech", "5A3", "Hlavní město Praha, Capital City Prague");
        mainPage.addPrivateRegionPlates("estonia", "A", "Tallinn");
        mainPage.addPrivateRegionPlates("france", "01", "Ain,LaonBourg-en-Bresse,Auvergne-Rhône-Alpes");
        mainPage.addPrivateRegionPlates("germany", "A", "Augsburg, Bavaria");
        mainPage.addPrivateRegionPlates("greece", "AZ", "Achaia prefecture - Patras");
        mainPage.addPrivateRegionPlates("hungary", "T", "Sep 2021");
        mainPage.addPrivateRegionPlates("ireland", "C", "Cork");
        mainPage.addPrivateRegionPlates("italian", "AG", "Agrigento");
        mainPage.addPrivateRegionPlates("kazakhstan", "01", "Нур-Султан");
        mainPage.addPrivateRegionPlates("kosovo", "01", "Pristina");
        mainPage.addPrivateRegionPlates("kyrgyzstan", "01", "Бишкек");
        mainPage.addPrivateRegionPlates("lithuania", "L", "Klaipėda County");
        mainPage.addPrivateRegionPlates("moldova", "BE", "Tighina");
        mainPage.addPrivateRegionPlates("montenegro", "BA", "Berane");
        mainPage.addPrivateRegionPlates("norway", "KE", "Drammen, Viken"); 
        mainPage.addPrivateRegionPlates("poland", "WX", "Województwo mazowieckie, Warszawa-Żoliborz");
        mainPage.addPrivateRegionPlates("romania", "AB", "Alba");
        mainPage.addPrivateRegionPlates("russia", "01", "Республика Адыгея");
        mainPage.addPrivateRegionPlates("slovakia", "BA", "Bratislava");
        mainPage.addPrivateRegionPlates("slovenia", "KK", "Brežice, Krško, Sevnica");
        mainPage.addPrivateRegionPlates("sweden", "AB", "City of Stockholm");
        mainPage.addPrivateRegionPlates("switzerland", "BE", "Bern");
        mainPage.addPrivateRegionPlates("turkey", "03", "Afyonkarahisar");
        mainPage.addPrivateRegionPlates("ukraine", "KH", "Донецкая область");
        mainPage.addPrivateRegionPlates("uzbekistan", "02", "город Ташкент");
    })

    it('Check all regions and desriptions for diplomatic plates', () => {
        mainPage.selectTypeOfPLates('Diplomatic plates');
        mainPage.addDiplomaticRegionPlates("austria", "1", "Vatican City");
        mainPage.addDiplomaticRegionPlates("croatia", "010", "Holy See");
        mainPage.addDiplomaticRegionPlates("estonia", "10", "Sweden");
        mainPage.addDiplomaticRegionPlates("france", "4", "Algeria");
        mainPage.addDiplomaticRegionPlates("germany", "11", "Egypt");
        mainPage.addDiplomaticRegionPlates("italian", "AM", "Cyprus");
        mainPage.addDiplomaticRegionPlates("kyrgyzstan", "03", "China");
        mainPage.addDiplomaticRegionPlates("lithuania", "05", "Denmark");
        mainPage.addDiplomaticRegionPlates("montenegro", "11", "Turkey");
        mainPage.addDiplomaticRegionPlates("norway", "14", "Belgium");
        mainPage.addDiplomaticRegionPlates("norway", "14", "Belgium");
        mainPage.addDiplomaticRegionPlates("poland", "072180", "Serbia");
        mainPage.addDiplomaticRegionPlates("romania", "105", "Austria");
        mainPage.addDiplomaticRegionPlates("sweden", "AB", "Albania");
        mainPage.addDiplomaticRegionPlates("switzerland", "4", "Australia");
    })
})