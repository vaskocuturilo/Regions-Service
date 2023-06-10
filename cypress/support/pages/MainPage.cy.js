/// <reference types ="cypress"/>
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
        inputCountries: () => cy.get('[name="countries"]').should('be.visible'),
        uploadImage: () => cy.get('[for="file-input"]').should('be.visible'),
        
    } 

    checkMainPageElementsAppears() {
        this.elements.title().should('eq','The application regions');
        this.elements.mainImage();
        this.elements.countryDropDown();
        this.elements.inputCountries();
        this.elements.uploadImage();
    }

    checkAppersCountriesInDropDown() {
        cy.get('#countries_list option').each( (item, index) => {
            cy.wrap(item).should('have.text', todosTitles[index])
            })
    }

    checkUploadImageFunctionality() {
        cy.get('#file-input').selectFile('cypress/fixtures/upload.jpg', {force: true});

        cy.get('#countries_image').should('have.attr', 'src').should('include','blob:http://localhost:8080/')
        cy.get('#countries_image').should('be.visible').and(($img) => {
        expect($img[0].naturalWidth).to.be.greaterThan(0)
        });
    }

    checkImageByCountry(country, imageUrl) {
        this.elements.countryDropDown().select(country);
        cy.get('#countries_image').should('have.attr', 'src').should('include', imageUrl);
    }

}

export const mainPage = new MainPage();