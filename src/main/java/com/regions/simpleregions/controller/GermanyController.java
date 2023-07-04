package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.GermanyEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.GermanyService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/germany/plates")
public class GermanyController {

    private final GermanyService germanyService;

    @GetMapping("/region/{region}")
    public ResponseEntity getGermanPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(germanyService.getGermanPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getGermanPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(germanyService.getGermanPlatesByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<GermanyEntity>> getAllGermanRegions() {
        return ResponseEntity.ok(germanyService.getAllRegions());
    }
}
