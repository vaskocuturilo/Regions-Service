package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.BritishEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.BritishService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/british/plates")
public class BritishController {

    private final BritishService britishService;

    @GetMapping("/region/{region}")
    public ResponseEntity getBritishPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(britishService.getBritishPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getBritishPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(britishService.getBritishPlatesByDescription(description));
        } catch (DescriptionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<BritishEntity>> getAllBritishRegions() {
        return ResponseEntity.ok(britishService.getAllRegions());
    }
}
