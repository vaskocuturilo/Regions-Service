package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.FranceEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.FranceService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/france/plates")
public class FranceController {
    private final FranceService franceService;

    @GetMapping("/region/{region}")
    public ResponseEntity getFrancePlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(franceService.getFrancePlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getFrancePlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(franceService.getFrancePlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<FranceEntity>> getAllFranceRegions() {
        return ResponseEntity.ok(franceService.getAllRegions());
    }
}
