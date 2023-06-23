package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.EstoniaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/v1/estonia")
public class EstoniaController {
    private final EstoniaService estoniaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getEstoniaRegionByNumber(@PathVariable String region) {
        try {
            return ResponseEntity.ok(estoniaService.getRegionByNumber(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getEstoniaRegionByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(estoniaService.getRegionByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllEstoniaRegions() {
        try {
            return ResponseEntity.ok(estoniaService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
