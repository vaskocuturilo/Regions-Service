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
        alertMessageBlock: () => cy.get('[data-cy="alert_message_block"]').should('be.visible'),

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

    addPrivateRegionPlates(country, region) {
        this.elements.countryDropDown().select(country);
        this.elements.inputRegion().type(region);
        this.elements.getByRegionButton().click();
        this.elements.jsonResultBlock()
        .contains("Województwo mazowieckie, Warszawa-Żoliborz");
    }

    addDiplomaticRegionPlates(country, region) {
        this.elements.diplomaticCountryDropDown().select(country);
        this.elements.inputDiplomaticRegion().type(region);
        this.elements.getDiplomaticByRegionButton().click();
        this.elements.jsonResultBlock()
        .contains("Serbia");
    }

    addDescriptionPlates(country, region) {
        this.elements.countryDropDown().select(country);
        this.elements.inputDescription().type(region);
        this.elements.getByDescriptionButton().click();
        this.elements.jsonResultBlock()
        .contains("WX");
    }


    addDiplomaticDescriptionPlates(country, region) {
        this.elements.diplomaticCountryDropDown().select(country);
        this.elements.inputDiplomaticDescription().type(region);
        this.elements.getDiplomaticByDescriptionButton().click();
        this.elements.jsonResultBlock()
        .contains("072");
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
    
    checkAppearsCountriesInDropDown() {
        cy.get('#countries_list option').each( (item, index) => {
            cy.wrap(item).should('have.text', todosTitles[index])
        })
    }

    checkUploadImageFunctionality() {
        cy.newUploadBlobFile(
            "upload.jpg",
            "jpeg document",
            '[data-cy="uploadFile"]'
          );
     
        cy.get('#countries_image').should('have.attr', 'src').should('include','blob:http://localhost:3000/')
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

    checkAlertMessage(text) {
      const stub = cy.stub()  
      cy.on ('window:alert', stub)
      cy.get('button').contains('Click me!').click().then(() => {
      expect(stub.getCall(0)).to.be.calledWith(text)      
     })  
   }

   tapByRegionButton(text) {
     this.elements.getByRegionButton().click();
     this.elements.inputRegion().type('11');
     this.checkAlertMessage(text);
   }

   tapDiplomaticByRegionButton(text) {
    this.elements.getDiplomaticByRegionButton().click();
    this.elements.inputDescription().type('11');
    this.checkAlertMessage(text);
  }
   
   tapByDescriptionButton(text) {
     this.elements.getByDescriptionButton().click();
     this.elements.inputDiplomaticRegion().type('11');
     this.checkAlertMessage(text);
   }

   tapDiplomaticByDescriptionButton(text) {
    this.elements.getDiplomaticByDescriptionButton().click();
    this.elements.inputDiplomaticDescription().type('11');
    this.checkAlertMessage(text);  
  }
}

export const mainPage = new MainPage();