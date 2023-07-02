package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.RomaniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.RomaniaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/romania/plates")
public class RomaniaController {

    private final RomaniaService romaniaService;

    @GetMapping("/region/{region}")
    public Object getRomaniaPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(romaniaService.getRomaniaPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public Object getRomaniaPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(romaniaService.getRomaniaPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<RomaniaEntity>> getAllRomaniaRegions() {
        return ResponseEntity.ok(romaniaService.getAllRegions());
    }
}
