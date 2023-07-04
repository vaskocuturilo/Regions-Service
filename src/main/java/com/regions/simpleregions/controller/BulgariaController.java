package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.BulgariaEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.BulgariaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/bulgaria/plates")
public class BulgariaController {
    private final BulgariaService bulgariaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getBulgariaPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(bulgariaService.getBulgariaPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getBulgariaPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(bulgariaService.getBulgariaPlatesByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<BulgariaEntity>> getAllBulgariaRegions() {
        return ResponseEntity.ok(bulgariaService.getAllRegions());
    }
}
