package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.ArmeniaEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.ArmeniaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/armenia/plates")
public class ArmeniaController {

    private final ArmeniaService armeniaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getArmeniaPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(armeniaService.getArmeniaPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getArmeniaPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(armeniaService.getArmeniaPlatesByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<ArmeniaEntity>> getAllArmeniaRegions() {
        return ResponseEntity.ok(armeniaService.getAllRegions());
    }
}
