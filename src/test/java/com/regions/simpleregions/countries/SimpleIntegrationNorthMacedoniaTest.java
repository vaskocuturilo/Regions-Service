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
class SimpleIntegrationNorthMacedoniaTest {

    @Autowired
    private MockMvc mockMvc;

    private String PATH = "/api/v1/macedonia/plates";

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Test
    void getRegionHandle_whenGetNorthMacedoniaByRegion_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/BE")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").isNotEmpty())
                .andExpect(jsonPath("$.description", equalTo("Berovo")));
    }

    @Test
    void getRegionHandle_whenGetNorthMacedoniaByDescription_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/Berovo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].description").isNotEmpty())
                .andExpect(jsonPath("$[*].region").isNotEmpty())
                .andExpect(jsonPath("$[*]", hasSize(1)));
    }

    @Test
    void getRegionHandle_whenGetNorthMacedoniaByDescriptionContains_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/Berovo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].region", equalTo("BE")))
                .andExpect(jsonPath("$[0].description", equalTo("Berovo")));
    }

    @Test
    void getRegionHandle_whenGetNorthMacedoniaWithoutDescription_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getRegionHandle_whenGetNorthMacedoniaWithoutRegion_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getRegionHandle_whenGetAllNorthMacedoniaRegions_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty())
                .andExpect(jsonPath("$[*]", hasSize(34)));
    }

    @Test
    void getRegionHandle_whenExceptionNorthMacedonia_thenStatus200() throws Exception {
        String region = "100";
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/" + region)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(String.format(regionNotFound, region)));
    }

    @Test
    void getRegionHandle_whenExceptionNorthMacedoniaByDescription_thenStatus400() throws Exception {
        String description = "TEEEEEE";
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/" + description)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(String.format(descriptionNotFound, description)));
    }
}
