package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.GreeceEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.GreeceService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/v1/greece/plates")
public class GreeceController {

    private final GreeceService greeceService;

    @GetMapping("/region/{region}")
    public ResponseEntity getGreecePlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(greeceService.getGreecePlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getGreecePlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(greeceService.getGreecePlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<GreeceEntity>> getAllGreeceRegionsByNumber() {
        return ResponseEntity.ok(greeceService.getAllRegions());
    }
}
