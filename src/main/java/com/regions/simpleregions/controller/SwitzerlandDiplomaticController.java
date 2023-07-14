package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.SwitzerlandDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.SwitzerlandDiplomaticService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/switzerland/diplomatic/plates")
public class SwitzerlandDiplomaticController {

    private final SwitzerlandDiplomaticService switzerlandDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getSwitzerlandDiplomaticPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(switzerlandDiplomaticService.getSwitzerlandDiplomaticPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getSwitzerlandDiplomaticPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(switzerlandDiplomaticService.getSwitzerlandDiplomaticPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<SwitzerlandDiplomaticEntity>> getAllSwitzerlandDiplomaticRegions() {
        return ResponseEntity.ok(switzerlandDiplomaticService.getAllSwitzerlandDiplomaticRegions());
    }
}
