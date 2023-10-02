package com.regions.simpleregions.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Disabled
class SimpleIntegrationUsersTest {

    @Value("${http.auth-token-header-name}")
    private String headerName;

    @Value("${http.auth-token}")
    private String authToken;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createNewUser() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();

        final String newUser = createUser();

        Map<String, Object> body = new HashMap<>();
        body.put("firstName", newUser);
        body.put("lastName", newUser);
        body.put("login", newUser);
        body.put("password", newUser);


        String PATH = "/api/v1/users/register";
        mockMvc.perform(MockMvcRequestBuilders
                        .post(PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(body))
                        .accept(MediaType.APPLICATION_JSON)
                        .header(headerName, authToken))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.firstName", equalTo(newUser)))
                .andExpect(jsonPath("$.lastName", equalTo(newUser)))
                .andExpect(jsonPath("$.login", equalTo(newUser)))
                .andExpect(jsonPath("$.token").isNotEmpty())
                .andExpect(jsonPath("$.oneTimePassword").isNotEmpty())
                .andExpect(jsonPath("$.oneTimePassword.id").isNotEmpty())
                .andExpect(jsonPath("$.oneTimePassword.oneTimePasswordCode").isNotEmpty())
                .andExpect(jsonPath("$.oneTimePassword.oneTimePasswordCode").isNotEmpty())
                .andExpect(jsonPath("$.oneTimePassword.expires").isNotEmpty())
                .andExpect(jsonPath("$.apiKey").isNotEmpty())
                .andExpect(jsonPath("$.apiKey.id").isNotEmpty())
                .andExpect(jsonPath("$.apiKey.apiKey").isNotEmpty())
                .andExpect(jsonPath("$.apiKey.expires").isNotEmpty());
    }

    private String createUser() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        return timeStamp + "@test.com";
    }
}
