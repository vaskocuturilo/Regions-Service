package com.regions.simpleregions.controller;


import com.regions.simpleregions.entity.SwedenEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.SwedenService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/sweden/plates")
public class SwedenController {

    private final SwedenService swedenService;

    @GetMapping("/region/{region}")
    public ResponseEntity getSwedenPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(swedenService.getSwedenPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getSwedenPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(swedenService.getSwedenPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<SwedenEntity>> getAllSwedenRegions() {
        return ResponseEntity.ok(swedenService.getAllRegions());
    }
}
