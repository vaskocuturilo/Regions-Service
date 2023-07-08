package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.EstoniaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.EstoniaDiplomaticService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/estonia/diplomatic/plates")
public class EstoniaDiplomaticController {
    private final EstoniaDiplomaticService estoniaDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getEstoniaDiplomaticPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(estoniaDiplomaticService.getEstoniaDiplomaticPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getEstoniaDiplomaticPlatesRegionByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(estoniaDiplomaticService.getEstoniaDiplomaticPlatesRegionByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<EstoniaDiplomaticEntity>> getAllEstoniaDiplomaticRegions() {
        return ResponseEntity.ok(estoniaDiplomaticService.getAllEstoniaDiplomaticRegions());
    }
}
