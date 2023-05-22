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
class SimpleIntegrationKosovoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRegionHandle_whenGetKosovo_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/kosovo")
                        .param("region", "01")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").isNotEmpty())
                .andExpect(jsonPath("$.description", equalTo("Pristina")));
    }

    @Test
    void getRegionHandle_whenGetAllKosovoRegions_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/kosovo/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty())
                .andExpect(jsonPath("$[*]", hasSize(7)));
    }

    @Test
    void getRegionHandle_whenExceptionKosovo_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/kosovo")
                        .param("region", "150")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Region not found."));
    }
}
