package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.service.RussiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RussiaController {

    RussiaService russiaService;

    public RussiaController(RussiaService russiaService) {
        this.russiaService = russiaService;
    }

    @GetMapping("/russia")
    public ResponseEntity getRussiaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(russiaService.getDescription(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping("/russia")
    public ResponseEntity getRussiaRegionByDescription(@RequestParam String description) {
        try {
            return ResponseEntity.ok(russiaService.getRegionNumber(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/russia/all")
    public ResponseEntity getAllRussiaRegions() {
        try {
            return ResponseEntity.ok(russiaService.getAllRegions());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
