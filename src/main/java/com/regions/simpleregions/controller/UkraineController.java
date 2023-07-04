package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.UkraineEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.UkraineService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/ukraine/plates")
public class UkraineController {
    private final UkraineService ukraineService;

    @GetMapping("/region/{region}")
    public ResponseEntity getUkrainePlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(ukraineService.getRegionByNumber(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getUkrainePlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(ukraineService.getRegionByDescription(description));
        } catch (DescriptionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<UkraineEntity>> getAllUkraineRegions() {
        return ResponseEntity.ok(ukraineService.getAllRegions());
    }
}
