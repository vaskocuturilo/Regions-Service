package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.TurkeyEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.TurkeyService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/turkey/plates")
public class TurkeyController {
    private final TurkeyService turkeyService;

    @GetMapping("/region/{region}")
    public ResponseEntity getTurkeyPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(turkeyService.getTurkeyPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getTurkeyPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(turkeyService.getTurkeyPlatesByDescription(description));
        } catch (DescriptionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<TurkeyEntity>> getAllTurkeyRegionsByNumber() {
        return ResponseEntity.ok(turkeyService.getAllRegions());
    }
}
