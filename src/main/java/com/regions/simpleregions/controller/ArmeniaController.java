package com.regions.simpleregions.controller;

import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.exception.RegionsNotFoundException;
import com.regions.simpleregions.service.ArmeniaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/armenia")
public class ArmeniaController {

    private final ArmeniaService armeniaService;

    public ArmeniaController(ArmeniaService armeniaService) {
        this.armeniaService = armeniaService;
    }

    @GetMapping("/region/{region}")
    public ResponseEntity getArmeniaRegionByNumber(@PathVariable String region) {
        try {
            return ResponseEntity.ok(armeniaService.getRegionNumber(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getRussiaRegionByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(armeniaService.getDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllArmeniaRegions() {
        try {
            return ResponseEntity.ok(armeniaService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
