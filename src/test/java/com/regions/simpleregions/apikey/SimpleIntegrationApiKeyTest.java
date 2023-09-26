package com.regions.simpleregions.apikey;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
class SimpleIntegrationApiKeyTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getApiKeyHandle_whenGetApiKeyForNewUser_thenStatus200() throws Exception {
        String PATH = "/api/v1/apiKey";
        mockMvc.perform(MockMvcRequestBuilders
                        .post(PATH)
                        .param("userId", "550e8400-e29b-41d4-a716-446655440000")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
