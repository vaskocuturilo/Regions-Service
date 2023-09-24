/// <reference types ="cypress"/>

export class NavSubPage {
    elements = {
        navBarMain: () => cy.get('.navbar-brand').should('be.visible'),
        signInButton: ()=> cy.get('[data-cy="signIn"]').should('be.visible'),
        signUpButton: ()=> cy.get('[data-cy="signUp"]').should('be.visible'),

        loginButton: ()=> cy.get('[data-cy="loginButton"]').should('be.visible'),
        cancelButton: ()=> cy.get('[data-cy="cancelButton"]').should('be.visible'),
        
        userInput: ()=> cy.get('[data-cy="userInput"]').should('be.visible'),
        pinInput: ()=> cy.get('[data-cy="pinInput"]').should('be.visible'),

        registerButton: ()=> cy.get('[data-cy="registerButton"]').should('be.visible'),
        cancelButton: ()=> cy.get('[data-cy="cancelButton"]').should('be.visible'),
        
        emailInput: ()=> cy.get('[data-cy="emailInput"]').should('be.visible'),
        nameInput: ()=> cy.get('[data-cy="nameInput"]').should('be.visible'),
        pinInput: ()=> cy.get('[data-cy="pinInput"]').should('be.visible')
    }


    checkNavigationBarByText(text) {
        this.elements.navBarMain().find('p').should('have.text', text);
    }

    checkSignInButton(text) {
        this.elements.signInButton().should('have.text', text);
        this.elements.signInButton().click();
        this.elements.loginButton();
        this.elements.userInput();
        this.elements.pinInput();
        this.elements.cancelButton().click();
    }

    checkSignUpButton(text) {
        this.elements.signUpButton().should('have.text', text);
        this.elements.signUpButton().click();
        this.elements.registerButton();
        this.elements.emailInput();
        this.elements.nameInput();
        this.elements.pinInput();
        this.elements.cancelButton().click();
    }
}

export const navSubPage = new NavSubPage();