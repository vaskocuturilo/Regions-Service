package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.RussiaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.RussiaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/russia/plates")
@Data
public class RussiaController {

    private final RussiaService russiaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getRussiaPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(russiaService.getRussiaPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("description/{description}")
    public ResponseEntity getRussiaPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(russiaService.getRussiaPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<RussiaEntity>> getAllRussiaRegions() {
        return ResponseEntity.ok(russiaService.getAllRegions());
    }
}
