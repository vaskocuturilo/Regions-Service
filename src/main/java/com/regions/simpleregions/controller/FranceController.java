package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.FranceEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.FranceService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("http://localhost:3000/")
@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/france/plates")
public class FranceController {
    private final FranceService franceService;

    @GetMapping("/region/{region}")
    public ResponseEntity getFrancePlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(franceService.getFrancePlatesByRegion(region));
        } catch (final RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getFrancePlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(franceService.getFrancePlatesByDescription(description));
        } catch (final DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<FranceEntity>> getAllFranceRegions() {
        return ResponseEntity.ok(franceService.getAllRegions());
    }
}
