package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.CzechEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.CzechService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/czech/plates")
@Data
public class CzechController {
    private final CzechService czechService;

    @GetMapping("/region/{region}")
    public ResponseEntity getCzechPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(czechService.getCzechPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getCzechPlatesRegionByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(czechService.getCzechPlatesRegionByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<CzechEntity>> getAllCzechRegions() {
        return ResponseEntity.ok(czechService.getAllRegions());
    }
}
