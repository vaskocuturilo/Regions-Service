package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.MoldovaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.MoldovaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/moldova/plates")
public class MoldovaController {

    private final MoldovaService moldovaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getMoldovaPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(moldovaService.getMoldovaPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getMoldovaPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(moldovaService.getMoldovaPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<MoldovaEntity>> getAllMoldovaRegions() {
        return ResponseEntity.ok(moldovaService.getAllRegions());
    }
}
