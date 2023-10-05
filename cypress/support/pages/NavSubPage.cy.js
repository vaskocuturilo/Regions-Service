/// <reference types ="cypress"/>

export class NavSubPage {
    elements = {
        navBarMain: () => cy.get('.navbar-brand').should('be.visible'),
        signInButton: ()=> cy.get('[data-cy="signIn"]').should('be.visible'),
        signUpButton: ()=> cy.get('[data-cy="signUp"]').should('be.visible'),

        loginButton: ()=> cy.get('[data-cy="loginButton"]').should('be.visible'),
        registerButton: ()=> cy.get('[data-cy="registerButton"]').should('be.visible'),
        cancelButton: ()=> cy.get('[data-cy="cancelButton"]').should('be.visible'),

        loginInput: ()=> cy.get('[data-cy="loginInput"]').should('be.visible'),
        passwordInput: ()=> cy.get('[data-cy="passwordInput"]').should('be.visible'),

        firstNameInput: ()=> cy.get('[data-cy="firstNameInput"]').should('be.visible'),
        lastnameNameInput: ()=> cy.get('[data-cy="lastNameInput"]').should('be.visible')
     }

    checkNavigationBarByText(text) {
        this.elements.navBarMain().find('p').should('have.text', text);
    }

    checkSignInButton(text) {
        this.elements.signInButton().should('have.text', text);
        this.elements.signInButton().click();
        this.elements.loginButton();
        this.elements.loginInput();
        this.elements.passwordInput();
        this.elements.cancelButton().click();
    }

    checkSignUpButton(text) {
        this.elements.signUpButton().should('have.text', text);
        this.elements.signUpButton().click();
        this.elements.registerButton();
        this.elements.firstNameInput();
        this.elements.lastnameNameInput();
        this.elements.loginInput();
        this.elements.passwordInput();
        this.elements.cancelButton().click();
    }
}

export const navSubPage = new NavSubPage();