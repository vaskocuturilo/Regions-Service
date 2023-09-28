package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.ApiKeyEntity;
import com.regions.simpleregions.service.ApiKeyService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/apiKey")
@Data
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    @PostMapping
    public ResponseEntity<ApiKeyEntity> getApiKey(@RequestParam UUID userId) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(apiKeyService.getApiKeyByUser(userId));
        } catch (Exception exception) {
            throw new IllegalStateException(String.format("Can't create one time password with fail message is %s", exception.getMessage()));
        }
    }
}