/// <reference types ="cypress"/>

export class NavSubPage {
    elements = {
        navBarMain: () => cy.get('.navbar-brand').should('be.visible'),
        signInButton: ()=> cy.get('[data-cy="signIn"]').should('be.visible'),
        signUpButton: ()=> cy.get('[data-cy="signUp"]').should('be.visible'),

        loginButton: ()=> cy.get('[data-cy="loginButton"]').should('be.visible'),
        cancelButton: ()=> cy.get('[data-cy="cancelButton"]').should('be.visible'),
        
        userInput: ()=> cy.get('[data-cy="loginButton"]').should('be.visible'),
        pinInput: ()=> cy.get('[data-cy="loginButton"]').should('be.visible'),

        registerButton: ()=> cy.get('[data-cy="registerButton"]').should('be.visible'),
        cancelButton: ()=> cy.get('[data-cy="cancelButton"]').should('be.visible'),
        
        emailInput: ()=> cy.get('[data-cy="loginButton"]').should('be.visible'),
        nameInput: ()=> cy.get('[data-cy="loginButton"]').should('be.visible'),
        pinInput: ()=> cy.get('[data-cy="loginButton"]').should('be.visible')
    }


    checkNavigationBarByText(text) {
        this.elements.navBarMain().find('p').should('have.text', text);
    }

    checkSignInButton(text) {
        this.elements.signInButton().should('have.text', text);
        this.elements.signInButton().click();
        this.elements.loginButton();
        this.elements.cancelButton().click();

        this.elements.userInput();
        this.elements.pinInput();

    }

    checkSignUpButton(text) {
        this.elements.signUpButton().should('have.text', text);
        this.elements.signUpButton().click();
        this.elements.registerButton();
        this.elements.cancelButton().click();

        this.elements.emailInput();
        this.elements.nameInput();
        this.elements.pinInput();
    }
}

export const navSubPage = new NavSubPage();