package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.SwitzerlandEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.SwitzerlandService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/switzerland/plates")
public class SwitzerlandController {

    private final SwitzerlandService switzerlandService;

    @GetMapping("/region/{region}")
    public ResponseEntity getSwitzerlandPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(switzerlandService.getSwitzerlandPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getSwitzerlandPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(switzerlandService.getSwitzerlandPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<SwitzerlandEntity>> getAllSwitzerlandRegions() {
        return ResponseEntity.ok(switzerlandService.getAllRegions());
    }
}
