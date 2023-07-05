package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.EstoniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.EstoniaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/estonia/plates")
public class EstoniaController {
    private final EstoniaService estoniaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getEstoniaPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(estoniaService.getEstoniaPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getEstoniaPlatesRegionByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(estoniaService.getEstoniaPlatesRegionByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<EstoniaEntity>> getAllEstoniaRegions() {
        return ResponseEntity.ok(estoniaService.getAllRegions());
    }
}
