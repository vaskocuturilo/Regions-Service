package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.PolandDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.PolandDiplomaticService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/poland/diplomatic/plates")
public class PolandDiplomaticController {

    private final PolandDiplomaticService polandDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getPolandPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(polandDiplomaticService.getPolandPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getPolandRegionByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(polandDiplomaticService.getPolandRegionByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<PolandDiplomaticEntity>> getAllPolandRegions() {
        return ResponseEntity.ok(polandDiplomaticService.getAllRegions());
    }
}
