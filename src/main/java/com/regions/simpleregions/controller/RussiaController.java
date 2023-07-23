package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.RussiaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.RussiaService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("http://localhost:3000/")
@Log4j2
@RestController
@RequestMapping("/api/v1/russia/plates")
@Data
public class RussiaController {

    private final RussiaService russiaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getRussiaPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(russiaService.getRussiaPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("description/{description}")
    public ResponseEntity getRussiaPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(russiaService.getRussiaPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<RussiaEntity>> getAllRussiaRegions() {
        return ResponseEntity.ok(russiaService.getAllRegions());
    }
}
