package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.BulgariaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.BulgariaService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("http://localhost:3000/")
@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/bulgaria/plates")
public class BulgariaController {
    private final BulgariaService bulgariaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getBulgariaPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(bulgariaService.getBulgariaPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getBulgariaPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(bulgariaService.getBulgariaPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<BulgariaEntity>> getAllBulgariaRegions() {
        return ResponseEntity.ok(bulgariaService.getAllRegions());
    }
}
