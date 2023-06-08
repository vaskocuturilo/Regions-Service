/// <reference types ="cypress"/>

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
        }
}

export const mainPage = new MainPage();