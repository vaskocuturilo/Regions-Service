package com.regions.simpleRegions.diplomatic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
class SimpleIntegrationPolandDiplomaticTest {

    @Autowired
    private MockMvc mockMvc;

    private String PATH = "/api/v1/poland/diplomatic";

    @Test
    void getRegionHandle_whenGetPolandByRegion_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/083077")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.region").isNotEmpty())
                .andExpect(jsonPath("$.description").isNotEmpty())
                .andExpect(jsonPath("$.destinationCode").isNotEmpty())
                .andExpect(jsonPath("$.region", equalTo("083")))
                .andExpect(jsonPath("$.destinationCode", equalTo("PRIVATE_VEHICLES")))
                .andExpect(jsonPath("$.description", equalTo("Ukraine")));
    }

    @Test
    void getRegionHandle_whenGetPolandByDescription_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/United States")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty())
                .andExpect(jsonPath("$[*].region").isNotEmpty())
                .andExpect(jsonPath("$[*].description").isNotEmpty())
                .andExpect(jsonPath("$[*]", hasSize(1)));
    }

    @Test
    void getRegionHandle_whenGetPolandByDescriptionContains_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/United States")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].region", equalTo("001")))
                .andExpect(jsonPath("$[0].description", equalTo("United States")));
    }


    @Test
    void getRegionHandle_whenGetAllPolandRegions_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty())
                .andExpect(jsonPath("$[*]", hasSize(115)));
    }

    @Test
    void getRegionHandle_whenGetPolandWithoutDescription_thenStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getRegionHandle_whenGetPolandWithoutRegion_thenStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getRegionHandle_whenExceptionPolandByRegion_thenStatus400() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/600")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Region not found."));
    }

    @Test
    void getRegionHandle_whenExceptionPolandByDescription_thenStatus400() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/TTTTTTTT")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Region not found."));
    }
}
