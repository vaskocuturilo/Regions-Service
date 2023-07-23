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
        diplomaticCountryDropDown : () => cy.get('#countries_diplomatic_list').should('be.visible'),
        
        inputRegion: () => cy.get('[data-cy="region_plates_input"]').should('be.visible'),
        inputDescription: () => cy.get('[data-cy="description_plates_input"]').should('be.visible'),
        getAllRegionsButton: () => cy.get('[data-cy="get_all_plates_by_coutry_button"]').should('be.visible'),
        getByRegionButton: () => cy.get('[data-cy="get_plates_by_region_button"]').should('be.visible'),
        getByDescriptionButton: () => cy.get('[data-cy="get_plates_by_description_button"]').should('be.visible'),
        
        inputDiplomaticRegion: () => cy.get('[data-cy="region_diplomatic_plates_input"]').should('be.visible'),
        inputDiplomaticDescription: () => cy.get('[data-cy="get_by_diplomatic_description_input"]').should('be.visible'),
        getAllDiplomaticPlatesButton: () => cy.get('[data-cy="get_all_diplomatic_plates_by_coutry_button"]').should('be.visible'),
        getDiplomaticByRegionButton: () => cy.get('[data-cy="get_diplomatic_plates_by_region_button"]').should('be.visible'),
        getDiplomaticByDescriptionButton: () => cy.get('[data-cy="get_diplomatic_plates_by_description"]').should('be.visible'),
        
        clearButton: () => cy.get('[data-cy="clear_button"]').should('be.visible'),
        uploadImage: () => cy.get('[for="file-input"]').should('be.visible')
    } 

    checkMainPageElementsAppears() {
        this.elements.title().should('eq','The application regions');
        this.elements.mainImage();
        this.elements.countryDropDown();
        this.elements.diplomaticCountryDropDown();
        this.elements.inputRegion();
        this.elements.inputDescription();
        this.elements.getAllRegionsButton();
        this.elements.getByRegionButton();
        this.elements.getByDescriptionButton();

        this.elements.inputDiplomaticRegion();
        this.elements.inputDiplomaticDescription();
        this.elements.getAllDiplomaticPlatesButton();
        this.elements.getDiplomaticByRegionButton();
        this.elements.getDiplomaticByDescriptionButton();
    }

    checkAppearsCountriesInDropDown() {
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

    checkImageDiplomaticByCountry(country, imageUrl) {
        this.elements.diplomaticCountryDropDown().select(country);
        cy.get('#countries_image').should('have.attr', 'src').should('include', imageUrl);
    }

}

export const mainPage = new MainPage();