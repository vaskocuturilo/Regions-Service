package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.CzechEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.CzechService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("http://localhost:3000/")
@Log4j2
@RestController
@RequestMapping("/api/v1/czech/plates")
@Data
public class CzechController {
    private final CzechService czechService;

    @GetMapping("/region/{region}")
    public ResponseEntity getCzechPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(czechService.getCzechPlatesByRegion(region));
        } catch (final RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getCzechPlatesRegionByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(czechService.getCzechPlatesRegionByDescription(description));
        } catch (final DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<CzechEntity>> getAllCzechRegions() {
        return ResponseEntity.ok(czechService.getAllRegions());
    }
}
