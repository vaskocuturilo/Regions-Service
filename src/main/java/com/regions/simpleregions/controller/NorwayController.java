package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.NorwayEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.NorwayService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/norway/plates")
public class NorwayController {

    private final NorwayService norwayService;

    @GetMapping("/region/{region}")
    public ResponseEntity getNorwayPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(norwayService.getNorwayPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getNorwayPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(norwayService.getNorwayPlatesByDescription(description));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<NorwayEntity>> getAllNorwayRegions() {
        return ResponseEntity.ok(norwayService.getAllRegions());
    }
}
