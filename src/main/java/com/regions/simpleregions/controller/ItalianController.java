package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.ItalianEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.ItalianService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/v1/italian/plates")
@Data
public class ItalianController {
    private final ItalianService italianService;

    @GetMapping("/region/{region}")
    public ResponseEntity getItalianPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(italianService.getItalianPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getItalianPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(italianService.getItalianPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<ItalianEntity>> getAllItalianRegions() {
        return ResponseEntity.ok(italianService.getAllRegions());
    }
}
