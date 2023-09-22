/// <reference types ="cypress"/>

import { navSubPage } from "../../support/pages/NavSubPage.cy"
import {mainPage} from "../../support/pages/MainPage.cy"

describe('Checking all countries. ', () => {
    beforeEach(() => {
        cy.visit('/')
    })


    it('Check all regions and desriptions for private plates', () => {
        mainPage.clearModal();
        navSubPage.checkNavigationBarByText('Regions Service');
        navSubPage.checkSignInButton('Sign In');
        navSubPage.checkSignUpButton('Sign Up');
    })
})