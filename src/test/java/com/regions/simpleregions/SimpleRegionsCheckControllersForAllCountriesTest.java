package com.regions.simpleregions;

import com.regions.simpleregions.controller.GermanyController;
import com.regions.simpleregions.controller.PolandController;
import com.regions.simpleregions.controller.RussiaController;
import com.regions.simpleregions.controller.SwedenController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class SimpleRegionsCheckControllersForAllCountriesTest {

    @Autowired
    RussiaController russiaController;

    @Autowired
    PolandController polandController;

    @Autowired
    GermanyController germanyController;

    @Autowired
    SwedenController swedenController;

    @Test
    public void testSimpleRegionsCheckRussiaController() {
        assertThat(russiaController).isNotNull();
    }

    @Test
    public void testSimpleRegionsCheckPolandController() {
        assertThat(polandController).isNotNull();
    }

    @Test
    public void testSimpleRegionsCheckGermanController() {
        assertThat(germanyController).isNotNull();
    }

    @Test
    public void testSimpleRegionsCheckSwedenController() {
        assertThat(swedenController).isNotNull();
    }
}
