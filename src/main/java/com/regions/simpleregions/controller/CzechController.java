package com.regions.simpleregions.controller;

import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.exception.RegionsNotFoundException;
import com.regions.simpleregions.service.CzechService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/czech/plates")
@Data
public class CzechController {
    private final CzechService czechService;

    @GetMapping("/region/{region}")
    public ResponseEntity getCzechRegionByNumber(@PathVariable String region) {
        try {
            return ResponseEntity.ok(czechService.getRegionByNumber(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getCzechRegionByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(czechService.getRegionByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllCzechRegions() {
        try {
            return ResponseEntity.ok(czechService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
