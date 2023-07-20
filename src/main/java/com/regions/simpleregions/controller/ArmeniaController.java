package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.ArmeniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.ArmeniaService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/armenia/plates")
public class ArmeniaController {

    private final ArmeniaService armeniaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getArmeniaPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(armeniaService.getArmeniaPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception);
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getArmeniaPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(armeniaService.getArmeniaPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception);
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<ArmeniaEntity>> getAllArmeniaRegions() {
        return ResponseEntity.ok(armeniaService.getAllRegions());
    }
}
