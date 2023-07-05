package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.PolandEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.PolandService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/poland/plates")
public class PolandController {

    private final PolandService polandService;

    @GetMapping("/region/{region}")
    public ResponseEntity getPolandPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(polandService.getPolandPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getPolandPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(polandService.getPolandPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<PolandEntity>> getAllPolandRegions() {
        return ResponseEntity.ok(polandService.getAllRegions());
    }
}
