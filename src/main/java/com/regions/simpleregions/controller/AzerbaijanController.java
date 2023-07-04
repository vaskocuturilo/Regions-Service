package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.AzerbaijanEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.AzerbaijanService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/azerbaijan/plates")
public class AzerbaijanController {

    private final AzerbaijanService azerbaijanService;

    @GetMapping("/region/{region}")
    public ResponseEntity getAzerbaijanPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(azerbaijanService.getAzerbaijanPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getAzerbaijanPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(azerbaijanService.getAzerbaijanPlatesByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<AzerbaijanEntity>> getAllAzerbaijanRegions() {
        return ResponseEntity.ok(azerbaijanService.getAllRegions());
    }
}
