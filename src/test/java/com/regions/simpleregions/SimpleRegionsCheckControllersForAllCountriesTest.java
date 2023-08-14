package com.regions.simpleregions;

import com.regions.simpleregions.controller.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


@SpringBootTest
class SimpleRegionsCheckControllersForAllCountriesTest {
    @Autowired
    ArmeniaController armeniaController;
    @Autowired
    AustriaController austriaController;
    @Autowired
    AustriaDiplomaticController austriaDiplomaticController;
    @Autowired
    AzerbaijanController azerbaijanController;
    @Autowired
    BelarusController belarusController;
    @Autowired
    BritishController britishController;
    @Autowired
    BulgariaController bulgariaController;
    @Autowired
    CroatiaController croatiaController;
    @Autowired
    CroatiaDiplomaticController croatiaDiplomaticController;
    @Autowired
    CzechController czechController;
    @Autowired
    EstoniaController estoniaController;

    @Autowired
    EstoniaDiplomaticController estoniaDiplomaticController;

    @Autowired
    FranceController franceController;

    @Autowired
    FranceDiplomaticController franceDiplomaticController;

    @Autowired
    GermanyController germanyController;

    @Autowired
    GermanyDiplomaticController germanyDiplomaticController;

    @Autowired
    GreeceController greeceController;

    @Autowired
    HungaryController hungaryController;
    @Autowired
    IrelandController irelandController;

    @Autowired
    ItalianController italianController;

    @Autowired
    ItalianDiplomaticController italianDiplomaticController;
    @Autowired
    KazakhstanController kazakhstanController;
    @Autowired
    KosovoController kosovoController;
    @Autowired
    KyrgyzstanController kyrgyzstanController;
    @Autowired
    KyrgyzstanDiplomaticController kyrgyzstanDiplomaticController;
    @Autowired
    LithuaniaController lithuaniaController;
    @Autowired
    LithuaniaDiplomaticController lithuaniaDiplomaticController;
    @Autowired
    MoldovaController moldovaController;
    @Autowired
    MontenegroController montenegroController;
    @Autowired
    MontenegroDiplomaticController montenegroDiplomaticController;
    @Autowired
    NorwayController norwayController;
    @Autowired
    NorwayDiplomaticController norwayDiplomaticController;
    @Autowired
    PolandController polandController;
    @Autowired
    PolandDiplomaticController polandDiplomaticController;

    @Autowired
    RomaniaController romaniaController;
    @Autowired
    RomaniaDiplomaticController romaniaDiplomaticController;
    @Autowired
    RussiaController russiaController;
    @Autowired
    SlovakiaController slovakiaController;
    @Autowired
    SloveniaController sloveniaController;
    @Autowired
    SwedenController swedenController;
    @Autowired
    SwedenDiplomaticController swedenDiplomaticController;
    @Autowired
    SwitzerlandController switzerlandController;
    @Autowired
    SwitzerlandDiplomaticController switzerlandDiplomaticController;
    @Autowired
    TurkeyController turkeyController;
    @Autowired
    UkraineController ukraineController;
    @Autowired
    UzbekistanController uzbekistanController;

    @Test
    void testSimpleRegionsCheckRussiaController() {
        assertAll(() -> {
            assertThat(armeniaController).isNotNull();
            assertThat(austriaController).isNotNull();
            assertThat(austriaDiplomaticController).isNotNull();
            assertThat(azerbaijanController).isNotNull();
            assertThat(belarusController).isNotNull();
            assertThat(britishController).isNotNull();
            assertThat(bulgariaController).isNotNull();
            assertThat(croatiaController).isNotNull();
            assertThat(croatiaDiplomaticController).isNotNull();
            assertThat(czechController).isNotNull();
            assertThat(estoniaController).isNotNull();
            assertThat(estoniaDiplomaticController).isNotNull();
            assertThat(franceController).isNotNull();
            assertThat(franceDiplomaticController).isNotNull();
            assertThat(germanyController).isNotNull();
            assertThat(germanyDiplomaticController).isNotNull();
            assertThat(greeceController).isNotNull();
            assertThat(hungaryController).isNotNull();
            assertThat(irelandController).isNotNull();
            assertThat(italianController).isNotNull();
            assertThat(italianDiplomaticController).isNotNull();
            assertThat(kazakhstanController).isNotNull();
            assertThat(kosovoController).isNotNull();
            assertThat(kyrgyzstanController).isNotNull();
            assertThat(kyrgyzstanDiplomaticController).isNotNull();
            assertThat(lithuaniaController).isNotNull();
            assertThat(lithuaniaDiplomaticController).isNotNull();
            assertThat(moldovaController).isNotNull();
            assertThat(montenegroController).isNotNull();
            assertThat(montenegroDiplomaticController).isNotNull();
            assertThat(norwayController).isNotNull();
            assertThat(norwayDiplomaticController).isNotNull();
            assertThat(polandController).isNotNull();
            assertThat(polandDiplomaticController).isNotNull();
            assertThat(romaniaController).isNotNull();
            assertThat(romaniaDiplomaticController).isNotNull();
            assertThat(russiaController).isNotNull();
            assertThat(slovakiaController).isNotNull();
            assertThat(sloveniaController).isNotNull();
            assertThat(swedenController).isNotNull();
            assertThat(swedenDiplomaticController).isNotNull();
            assertThat(switzerlandController).isNotNull();
            assertThat(switzerlandDiplomaticController).isNotNull();
            assertThat(turkeyController).isNotNull();
            assertThat(ukraineController).isNotNull();
            assertThat(uzbekistanController).isNotNull();
        });
    }
}
