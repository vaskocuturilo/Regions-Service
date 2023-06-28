package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.KosovoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kosovo/plates")
public class KosovoController {

    KosovoService kosovoService;

    public KosovoController(KosovoService kosovoService) {
        this.kosovoService = kosovoService;
    }

    @GetMapping("/region/{region}")
    public ResponseEntity getKosovoPlatesByRegion(@PathVariable String region) {
        try {
            return ResponseEntity.ok(kosovoService.getKosovoPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getKosovoPlatesByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(kosovoService.getKosovoPlatesByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllKosovoRegions() {
        try {
            return ResponseEntity.ok(kosovoService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
