package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.AzerbaijanEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.AzerbaijanService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("http://localhost:3000/")
@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/azerbaijan/plates")
public class AzerbaijanController {

    private final AzerbaijanService azerbaijanService;

    @GetMapping("/region/{region}")
    public ResponseEntity getAzerbaijanPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(azerbaijanService.getAzerbaijanPlatesByRegion(region));
        } catch (final RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getAzerbaijanPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(azerbaijanService.getAzerbaijanPlatesByDescription(description));
        } catch (final DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<AzerbaijanEntity>> getAllAzerbaijanRegions() {
        return ResponseEntity.ok(azerbaijanService.getAllRegions());
    }
}
