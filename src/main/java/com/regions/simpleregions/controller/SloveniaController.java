package com.regions.simpleregions.controller;

import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.SloveniaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/slovenia/plates")
public class SloveniaController {

    private final SloveniaService sloveniaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getSloveniaRegionByNumber(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(sloveniaService.getSlovakiaPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getSloveniaRegionByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(sloveniaService.getSlovakiaPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable> getAllSloveniaRegions() {
        return ResponseEntity.ok(sloveniaService.getAllRegions());
    }
}