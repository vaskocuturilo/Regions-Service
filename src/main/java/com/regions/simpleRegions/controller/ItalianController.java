package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.ItalianService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/italian")
@Data
public class ItalianController {
    private final ItalianService italianService;

    @GetMapping("/region/{region}")
    public ResponseEntity getItalianRegionByNumber(@PathVariable String region) {
        try {
            return ResponseEntity.ok(italianService.getRegionByNumber(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getItalianRegionByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(italianService.getRegionByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllItalianRegions() {
        try {
            return ResponseEntity.ok(italianService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
