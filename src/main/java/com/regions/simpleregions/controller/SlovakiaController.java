package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.SlovakiaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.SlovakiaService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("http://localhost:3000/")
@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/slovakia/plates")
public class SlovakiaController {

    private final SlovakiaService slovakiaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getSlovakiaPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(slovakiaService.getSlovakiaPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getSlovakiaRegionByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(slovakiaService.getSlovakiaPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<SlovakiaEntity>> getAllSlovakiaRegions() {
        return ResponseEntity.ok(slovakiaService.getAllRegions());
    }
}
