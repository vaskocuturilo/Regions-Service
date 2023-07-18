package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.EstoniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.EstoniaService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/estonia/plates")
public class EstoniaController {
    private final EstoniaService estoniaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getEstoniaPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(estoniaService.getEstoniaDiplomaticPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getEstoniaPlatesRegionByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(estoniaService.getEstoniaDiplomaticPlatesRegionByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<EstoniaEntity>> getAllEstoniaRegions() {
        return ResponseEntity.ok(estoniaService.getAllRegions());
    }
}
