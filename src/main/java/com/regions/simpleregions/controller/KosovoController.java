package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.KosovoEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.KosovoService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/kosovo/plates")
public class KosovoController {
    private final KosovoService kosovoService;

    @GetMapping("/region/{region}")
    public ResponseEntity getKosovoPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(kosovoService.getKosovoPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getKosovoPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(kosovoService.getKosovoPlatesByDescription(description));
        } catch (DescriptionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<KosovoEntity>> getAllKosovoRegions() {
        return ResponseEntity.ok(kosovoService.getAllRegions());
    }
}
