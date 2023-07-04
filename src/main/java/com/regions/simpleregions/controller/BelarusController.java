package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.BelarusEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.exception.RegionsNotFoundException;
import com.regions.simpleregions.service.BelarusService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/v1/belarus/plates")
public class BelarusController {

    private final BelarusService belarusService;

    @GetMapping("/region/{region}")
    public ResponseEntity getBelarusPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(belarusService.getBelarusPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getBelarusPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(belarusService.getBelarusPlatesByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<BelarusEntity>> getAllBelarusRegions() {
        return ResponseEntity.ok(belarusService.getAllRegions());
    }
}
