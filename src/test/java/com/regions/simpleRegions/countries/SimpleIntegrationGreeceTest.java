package com.regions.simpleRegions.countries;

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
class SimpleIntegrationGreeceTest {

    @Autowired
    private MockMvc mockMvc;

    private String PATH = "/api/v1/greece";

    @Test
    void getRegionHandle_whenGetGreece_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/AX")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.region").isNotEmpty())
                .andExpect(jsonPath("$.region", equalTo("AX")))
                .andExpect(jsonPath("$.description").isNotEmpty())
                .andExpect(jsonPath("$.description", equalTo("Achaia prefecture - Patras")));
    }

    @Test
    void getRegionHandle_whenGetGreeceByDescription_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/Achaia prefecture - Patras")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty())
                .andExpect(jsonPath("$[*].region").isNotEmpty())
                .andExpect(jsonPath("$[*].description").isNotEmpty())
                .andExpect(jsonPath("$[*]", hasSize(5)));
    }


    @Test
    void getRegionHandle_whenGetGreeceByDescriptionContains_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/Achaia")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].region", equalTo("AA")))
                .andExpect(jsonPath("$[0].description", equalTo("Achaia prefecture - Patras")));
    }

    @Test
    void getRegionHandle_whenGetAllGreeceRegions_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty())
                .andExpect(jsonPath("$[*]", hasSize(220)));
    }

    @Test
    void getRegionHandle_whenGetRussiaWithoutDescription_thenStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getRegionHandle_whenGetRussiaWithoutRegion_thenStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getRegionHandle_whenExceptionRussiaByRegion_thenStatus400() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/AAAAA")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Region with number AAAAA not found."));
    }

    @Test
    void getRegionHandle_whenExceptionRussiaByDescription_thenStatus400() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/Tuataaaa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Region with description Tuataaaa not found."));
    }
}
