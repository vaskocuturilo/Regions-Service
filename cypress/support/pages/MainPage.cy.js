/// <reference types ="cypress"/>
export class MainPage {
    elements = {
        title : () => cy.title(),
        mainImage: () => cy.get('#countries_image').should('be.visible'),
        alertMessageBlock: () => cy.get('[data-cy="alert_message_block"]').should('be.visible'),
        navBarBottomLine: () => cy.get('[data-cy="nav-bar-bottom"]').should('be.visible'),
        navBarBottomMenu: () => cy.get('[data-cy="nav-bar-button"]').should('be.visible'),


        privatePlatesLabel: () => cy.get('[data-cy="private_label"]').should('be.visible'),
        diplomaticPlatesLabel: () => cy.get('[data-cy="diplomatic_label"]').should('be.visible'),
        uploadPhotoLabel: () => cy.get('[data-cy="upload_photo_label"]').should('be.visible'),

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
        uploadImage: () => cy.get('[data-cy="upload_photo_image"]').should('be.visible'),
        uploadPhotoText: () => cy.get('[data-cy="upload_photo_h3_text"]').should('be.visible'),
        jsonResultBlock: () => cy.get('div[id="json-pretty"]').should('be.visible')
    } 

    checkDefaultMainPageElementsAppears() {
        this.elements.title().should('eq','The application regions');
        this.elements.mainImage();
        this.elements.alertMessageBlock().should('have.text', 'Please choose any type of plates');

        this.elements.privatePlatesLabel();
        this.elements.diplomaticPlatesLabel();
        this.elements.uploadPhotoLabel();
    }

    selectTypeOfPLates(name) {
        const regExName = name.replace(/\s+/g, "_");
        console.log(regExName.toLowerCase());
        cy.get('[type="radio"]').check(regExName.toLowerCase())
    }

    addPrivateRegionPlates(filename) {
        cy.fixture(filename).then((data) => {
            data.forEach((items) => {
            this.elements.countryDropDown().select(items.country);
            this.elements.inputRegion().type(items.region);
            this.elements.getByRegionButton().click();
            this.elements.jsonResultBlock().contains(items.result);
        })
    })
}

    addDiplomaticRegionPlates(filename) {
        cy.fixture(filename).then((data) => {
            data.forEach((items) => {
                this.elements.diplomaticCountryDropDown().select(items.country);
                this.elements.inputDiplomaticRegion().type(items.region);
                this.elements.getDiplomaticByRegionButton().click();
                this.elements.jsonResultBlock().contains(items.result);
        })
    })
}

    addDescriptionPlates(filename) {
        cy.fixture(filename).then((data) => {
            data.forEach((items) => {
                this.elements.countryDropDown().select(items.country);
                this.elements.inputDescription().type(items.result);
                this.elements.getByDescriptionButton().click();
                this.elements.jsonResultBlock().contains(items.description);
        })
    })
}

    addDiplomaticDescriptionPlates(filename) {

        cy.fixture(filename).then((data) => {
            data.forEach((items) => {
                this.elements.diplomaticCountryDropDown().select(items.country);
                this.elements.inputDiplomaticDescription().type(items.result);
                this.elements.getDiplomaticByDescriptionButton().click();
                this.elements.jsonResultBlock().contains(items.description);
        })
    })
}

    checkAppearsPrivatePlatesBlock() {
        this.elements.privatePlatesLabel().click();
        this.elements.countryDropDown();
        this.elements.inputRegion();
        this.elements.inputDescription();
        this.elements.getByRegionButton();
        this.elements.getByDescriptionButton();
        this.elements.clearButton();
    }

    checkAppearsDiplomaticPlatesBlock() {
        this.elements.diplomaticPlatesLabel().click();
        this.elements.diplomaticCountryDropDown();
        this.elements.inputDiplomaticRegion();
        this.elements.inputDiplomaticDescription();
        this.elements.getDiplomaticByRegionButton();
        this.elements.getDiplomaticByDescriptionButton();
        this.elements.clearButton();

    }

    checkAppearsUploadPhotoBlock() {
        this.elements.uploadPhotoLabel().click({ multiple: true });
        this.elements.uploadPhotoText().should('have.text', 'Upload photo with car plate');
        this.elements.uploadImage().should('have.attr', 'src').should('include','data:image/png;base64')
        this.elements.uploadImage().should('be.visible').and(($img) => {
        expect($img[0].naturalWidth).to.be.greaterThan(0)
        });
    }

    checkAppearsNavBarMenu() {
        this.elements.navBarBottomLine();
        this.elements.navBarBottomMenu();
    }
    
    checkAppearsPrivateCountriesInDropDown(filename) {
        cy.fixture(filename).then((testdata) => {
            cy.get('#countries_list option').each( (item, index) => {
                cy.wrap(item).should('have.text', testdata.values[index])
            })
        })
    }

    checkAppearsDiplomaticCountriesInDropDown(filename) {
        cy.fixture(filename).then((testdata) => {
            cy.get('#countries_diplomatic_list option').each( (item, index) => {
                cy.wrap(item).should('have.text', testdata.values[index])
            })
        })
    }

    checkUploadImageFunctionality() {
        cy.get('#file-input').selectFile('cypress/fixtures/upload.jpg', {force: true});
     
        cy.get('#countries_image').should('have.attr', 'src').should('include','blob:http://localhost:3000/')
        cy.get('#countries_image').should('be.visible').and(($img) => {
        expect($img[0].naturalWidth).to.be.greaterThan(0)
        });
    }
    
    checkThatMainImageVisibleCorrectly(){
        cy.get('#countries_image').should('have.attr', 'src').should('include','/static/media/logo.2844f41831fc92c34483.jpg')
        cy.get('#countries_image').should('be.visible').and(($img) => {
        expect($img[0].naturalWidth).to.be.greaterThan(0)
      });
    }
    

    checkImageByCountry(filename) {
        cy.fixture(filename).then((data) => {
            data.forEach((items) => {
                this.elements.countryDropDown().select(items.country);
                cy.get('#countries_image').should('have.attr', 'src').should('include', items.imageUrl);
        })
      })
    }

    checkImageDiplomaticByCountry(filename) {
        cy.fixture(filename).then((data) => {
            data.forEach((items) => {
                this.elements.diplomaticCountryDropDown().select(items.country);
                cy.get('#countries_image').should('have.attr', 'src').should('include', items.imageUrl);
        })
      })
    }

    checkAlertMessage(text) {
    cy.on('window:alert', (str) => {
    expect(str).to.equal(text);
     })  
   }

   tapByRegionButton(text) {
     this.elements.getByRegionButton().click();
     this.elements.inputRegion().type('11');
     this.checkAlertMessage(text);
   }

   tapDiplomaticByRegionButton(text) {
    this.elements.getDiplomaticByRegionButton().click();
    this.elements.inputDiplomaticRegion().type('11');
    this.checkAlertMessage(text);
    
  }
   
   tapByDescriptionButton(text) {
     this.elements.getByDescriptionButton().click();
     this.elements.inputDescription().type('11');
     this.checkAlertMessage(text);
   }

   tapDiplomaticByDescriptionButton(text) {
    this.elements.getDiplomaticByDescriptionButton().click();
    this.elements.inputDiplomaticDescription().type('11');
    this.checkAlertMessage(text);  
  }
}

export const mainPage = new MainPage();