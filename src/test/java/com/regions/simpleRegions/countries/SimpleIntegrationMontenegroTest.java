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
class SimpleIntegrationMontenegroTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRegionHandle_whenGetMontenegro_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/montenegro")
                        .param("region", "AN")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").isNotEmpty())
                .andExpect(jsonPath("$.description", equalTo("Andrijevica")));
    }

    @Test
    void getRegionHandle_whenGetAllMontenegroRegions_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/montenegro/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty())
                .andExpect(jsonPath("$[*]", hasSize(24)));
    }

    @Test
    void getRegionHandle_whenExceptionMontenegro_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/montenegro")
                        .param("region", "ANA")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Region not found."));
    }
}
