package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.UkraineEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.UkraineService;
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
@RequestMapping("/api/v1/ukraine/plates")
public class UkraineController {
    private final UkraineService ukraineService;

    @GetMapping("/region/{region}")
    public ResponseEntity getUkrainePlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(ukraineService.getUkrainePlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getUkrainePlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(ukraineService.getUkrainePlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<UkraineEntity>> getAllUkraineRegions() {
        return ResponseEntity.ok(ukraineService.getAllRegions());
    }
}
