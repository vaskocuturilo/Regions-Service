package com.regions.simpleregions.controller;


import com.regions.simpleregions.entity.UzbekistanEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.UzbekistanService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("http://localhost:3000/")
@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/uzbekistan/plates")
public class UzbekistanController {

    private final UzbekistanService uzbekistanService;

    @GetMapping("/region/{region}")
    public ResponseEntity getUzbekistanPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(uzbekistanService.getUzbekistanPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getUzbekistanRegionByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(uzbekistanService.getUzbekistanPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<UzbekistanEntity>> getAllUzbekistanRegions() {
        return ResponseEntity.ok(uzbekistanService.getAllRegions());
    }
}
