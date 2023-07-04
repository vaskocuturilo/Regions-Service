package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.GreeceEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.GreeceService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/v1/greece/plates")
public class GreeceController {

    private final GreeceService greeceService;

    @GetMapping("/region/{region}")
    public ResponseEntity getGreecePlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(greeceService.getGreecePlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getGreecePlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(greeceService.getGreecePlatesByDescription(description));
        } catch (DescriptionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<GreeceEntity>> getAllGreeceRegionsByNumber() {
        return ResponseEntity.ok(greeceService.getAllRegions());
    }
}
