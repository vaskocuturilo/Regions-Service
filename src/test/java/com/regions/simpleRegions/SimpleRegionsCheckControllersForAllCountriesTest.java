package com.regions.simpleRegions;

import com.regions.simpleRegions.controller.GermanController;
import com.regions.simpleRegions.controller.PolandController;
import com.regions.simpleRegions.controller.RussiaController;
import com.regions.simpleRegions.controller.SwedenController;
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
    GermanController germanController;

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
        assertThat(germanController).isNotNull();
    }

    @Test
    public void testSimpleRegionsCheckSwedenController() {
        assertThat(swedenController).isNotNull();
    }
}
