package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.TurkeyService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/v1/turkey/plates")
public class TurkeyController {
    private final TurkeyService turkeyService;

    @GetMapping("/region/{region}")
    public ResponseEntity getTurkeyPlatesByRegion(@PathVariable String region) {
        try {
            return ResponseEntity.ok(turkeyService.getTurkeyPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getTurkeyPlatesByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(turkeyService.getTurkeyPlatesByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllTurkeyRegionsByNumber() {
        try {
            return ResponseEntity.ok(turkeyService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
