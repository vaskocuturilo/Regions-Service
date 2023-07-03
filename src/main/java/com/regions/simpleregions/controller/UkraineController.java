package com.regions.simpleregions.controller;

import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.exception.RegionsNotFoundException;
import com.regions.simpleregions.service.UkraineService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/v1/ukraine/plates")
public class UkraineController {
    private final UkraineService ukraineService;

    @GetMapping("/region/{region}")
    public ResponseEntity getUkraineRegionByNumber(@PathVariable String region) {
        try {
            return ResponseEntity.ok(ukraineService.getRegionByNumber(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getUkraineRegionByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(ukraineService.getRegionByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllUkraineRegions() {
        try {
            return ResponseEntity.ok(ukraineService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
