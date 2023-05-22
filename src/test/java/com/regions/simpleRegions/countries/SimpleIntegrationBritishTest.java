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
class SimpleIntegrationBritishTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRegionHandle_whenGetBritish_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/british")
                        .param("region", "AA")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").isNotEmpty())
                .andExpect(jsonPath("$.description", equalTo("Anglia, Peterborough")));
    }

    @Test
    void getRegionHandle_whenGetAllBritishRegions_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/british/all")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isNotEmpty())
                .andExpect(jsonPath("$[*]", hasSize(478)));
    }

    @Test
    void getRegionHandle_whenExceptionBritish_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/british")
                        .param("region", "AAA")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("Region not found."));
    }
}
