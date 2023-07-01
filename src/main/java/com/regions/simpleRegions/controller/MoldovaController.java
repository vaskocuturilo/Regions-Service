package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.DescriptionNotFoundException;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.MoldovaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/v1/moldova/plates")
public class MoldovaController {

    private final MoldovaService moldovaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getMoldovaPlatesByRegion(@PathVariable String region) {
        try {
            return ResponseEntity.ok(moldovaService.getMoldovaPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getMoldovaPlatesByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(moldovaService.getMoldovaPlatesByDescription(description));
        } catch (DescriptionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllMoldovaRegions() {
        try {
            return ResponseEntity.ok(moldovaService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
