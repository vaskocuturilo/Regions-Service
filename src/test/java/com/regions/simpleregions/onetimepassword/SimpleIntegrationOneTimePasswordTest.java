package com.regions.simpleregions.onetimepassword;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
class SimpleIntegrationOneTimePasswordTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRegionHandle_whenGetArmeniaByRegion_thenStatus200() throws Exception {
        String PATH = "/api/v1/one-time-password";
        mockMvc.perform(MockMvcRequestBuilders
                        .post(PATH)
                        .param("userId", "550e8400-e29b-41d4-a716-446655440000")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
