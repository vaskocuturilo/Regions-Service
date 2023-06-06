package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.FranceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/france")
public class FranceController {

    FranceService franceService;

    public FranceController(FranceService franceService) {
        this.franceService = franceService;
    }

    @GetMapping("/region/{region}")
    public ResponseEntity getFranceRegionByNumber(@PathVariable String region) {
        try {
            return ResponseEntity.ok(franceService.getByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getFranceRegionByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(franceService.getByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllFranceRegions() {
        try {
            return ResponseEntity.ok(franceService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
