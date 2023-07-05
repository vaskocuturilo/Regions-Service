package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.AustriaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.AustriaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/austria/plates")
public class AustriaController {
    private final AustriaService austriaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getAustriaPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(austriaService.getAustriaPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getAustriaPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(austriaService.getAustriaPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<AustriaEntity>> getAllAustriaRegions() {
        return ResponseEntity.ok(austriaService.getAllRegions());
    }
}
