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
class SimpleIntegrationKazakhstanTest {

    @Autowired
    private MockMvc mockMvc;

    private final String PATH = "/api/v1/kazakhstan/plates";

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${http.auth-token-header-name}")
    private String headerName;

    @Value("${http.auth-token}")
    private String authToken;

    @Test
    void getRegionHandle_whenGetKazakhstanPlatesByRegion_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/01")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).header(headerName, authToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.region").isNotEmpty())
                .andExpect(jsonPath("$.region", equalTo("01")))
                .andExpect(jsonPath("$.description").isNotEmpty())
                .andExpect(jsonPath("$.description", equalTo("Нур-Султан")));
    }

    @Test
    void getRegionHandle_whenGetKazakhstanPlatesByDescription_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/Нур-Султан")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).header(headerName, authToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty())
                .andExpect(jsonPath("$[*].region").isNotEmpty())
                .andExpect(jsonPath("$[*].description").isNotEmpty())
                .andExpect(jsonPath("$[*]", hasSize(1)));
    }

    @Test
    void getRegionHandle_whenGetKazakhstanByDescriptionContains_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/Нур")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).header(headerName, authToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].region", equalTo("01")))
                .andExpect(jsonPath("$[0].description", equalTo("Нур-Султан")));
    }

    @Test
    void getRegionHandle_whenGetAllKazakhstanRegions_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).header(headerName, authToken))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty())
                .andExpect(jsonPath("$[*]", hasSize(18)));
    }

    @Test
    void getRegionHandle_whenGetKazakhstanPlatesWithoutDescription_thenStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).header(headerName, authToken))
                .andExpect(status().isNotFound());
    }

    @Test
    void getRegionHandle_whenGetKazakhstanPlatesWithoutRegion_thenStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).header(headerName, authToken))
                .andExpect(status().isNotFound());
    }

    @Test
    void getRegionHandle_whenExceptionKazakhstanPlatesByRegion_thenStatus400() throws Exception {
        String region = "60";
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/" + region)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).header(headerName, authToken))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(String.format(regionNotFound, region)));
    }

    @Test
    void getRegionHandle_whenExceptionKazakhstanPlatesByDescription_thenStatus400() throws Exception {
        String description = "WWWWWWW";
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/description/" + description)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).header(headerName, authToken))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(String.format(descriptionNotFound, description)));
    }

    @Test
    void getRegionHandle_whenGetKazakhstanWithoutApiKey_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(PATH + "/region/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }
}
