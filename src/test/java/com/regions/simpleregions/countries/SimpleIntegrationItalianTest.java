package com.regions.simpleregions.countries;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SimpleIntegrationItalianTest {

    @Autowired
    private MockMvc mockMvc;

    private String PATH = "/api/v1/italian/plates";

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Test
    void getRegionHandle_whenGetItalianByRegion_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/AG")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.region").isNotEmpty())
                .andExpect(jsonPath("$.description").isNotEmpty())
                .andExpect(jsonPath("$.region", equalTo("AG")))
                .andExpect(jsonPath("$.description", equalTo("Agrigento")));
    }

    @Test
    void getRegionHandle_whenGetItalianByDescription_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/Agrigento")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty())
                .andExpect(jsonPath("$[*].region").isNotEmpty())
                .andExpect(jsonPath("$[*].description").isNotEmpty())
                .andExpect(jsonPath("$[*]", hasSize(1)));
    }

    @Test
    void getRegionHandle_whenGetItalianByDescriptionContains_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/Flo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].region", equalTo("FI")))
                .andExpect(jsonPath("$[0].description", equalTo("Florence (Firenze)")));
    }

    @Test
    void getRegionHandle_whenGetAllItalianRegions_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty())
                .andExpect(jsonPath("$[*]", hasSize(107)));
    }

    @Test
    void getRegionHandle_whenGetItalianWithoutDescription_thenStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getRegionHandle_whenGetItalianWithoutRegion_thenStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getRegionHandle_whenExceptionItalianByRegion_thenStatus400() throws Exception {
        String region = "600";
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/" + region)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(String.format(regionNotFound, region)));
    }

    @Test
    void getRegionHandle_whenExceptionItalianByDescription_thenStatus400() throws Exception {
        String description = "WWWWWWW";
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/" + description)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(String.format(descriptionNotFound, description)));
    }
}
