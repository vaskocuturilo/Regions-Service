package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.NorthMacedoniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.NorthMacedoniaService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("http://localhost:3000/")
@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/macedonia/plates")
public class NorthMacedoniaController {

    private final NorthMacedoniaService northMacedoniaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getNorthMacedoniaPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(northMacedoniaService.getNorthMacedoniaPlatesByRegion(region));
        } catch (final RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception);
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getNorthMacedoniaPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(northMacedoniaService.getNorthMacedoniaPlatesByDescription(description));
        } catch (final DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception);
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<NorthMacedoniaEntity>> getAllArmeniaRegions() {
        return ResponseEntity.ok(northMacedoniaService.getAllRegions());
    }
}
