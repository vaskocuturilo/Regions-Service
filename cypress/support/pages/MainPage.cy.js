/// <reference types ="cypress"/>

const items = []

const todosTitles = [
"Choose country", 
"🇦🇲 Armenia", 
"🇦🇹 Austria", 
"🇦🇿 Azerbaijan", 
"🇧🇾 Belarus", 
"🇻🇬 Great Britain",
"🇧🇬 Bulgaria",
"🇭🇷 Croatia",
"🇨🇿 Czech Republic",
"🇪🇪 Estonia",
"🇫🇷 France",
"🇩🇪 Germany",
"🇬🇷 Greece",
"🇭🇺 Hungary",
"🇮🇪 Ireland",
"🇮🇹 Italy",
"🇰🇿 Kazakhstan",
"🇽🇰 Kosovo",
"🇰🇬 Kyrgyzstan",
"🇱🇹 Lithuania",
"🇲🇩 Moldova",
"🇲🇪 Montenegro",
"🇳🇴 Norway",
"🇵🇱 Poland",
"🇷🇴 Romania",
"🇷🇺 Russia",
"🇸🇰 Slovakia",
"🇸🇮 Slovenia",
"🇸🇪 Sweden",
"🇨🇭 Switzerland",
"🇹🇷 Turkey",
"🇺🇦 Ukraine",
"🇺🇿 Uzbekistan"];

export class MainPage {
    elements = {
        title : () => cy.title(),
        mainImage: () => cy.get('#countries_image').should('be.visible'),
        countryDropDown : () => cy.get('#countries_list').should('be.visible'),
        inputCountries: () => cy.get('[name="countries"]').should('be.visible')
    } 

    

    checkMainPageElementsIsAppers() {
        this.elements.title().should('eq','The application regions');
        this.elements.mainImage();
        this.elements.countryDropDown();
        this.elements.inputCountries();
    
        cy
        .get('#countries_list option').each( (item, index) => {
    
          cy
            .wrap(item)
            .should('have.text', todosTitles[index])
            
        })
    }
}

export const mainPage = new MainPage();