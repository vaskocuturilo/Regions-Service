package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.SlovakiaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.SlovakiaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/slovakia/plates")
public class SlovakiaController {

    private final SlovakiaService slovakiaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getSlovakiaPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(slovakiaService.getSlovakiaPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getSlovakiaRegionByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(slovakiaService.getSlovakiaPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<SlovakiaEntity>> getAllSlovakiaRegions() {
        return ResponseEntity.ok(slovakiaService.getAllRegions());
    }
}
