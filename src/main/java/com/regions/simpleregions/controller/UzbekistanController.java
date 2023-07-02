package com.regions.simpleregions.controller;


import com.regions.simpleregions.entity.UzbekistanEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.UzbekistanService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/uzbekistan/plates")
public class UzbekistanController {

    private final UzbekistanService uzbekistanService;

    @GetMapping("/region/{region}")
    public ResponseEntity getUzbekistanRegionByNumber(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(uzbekistanService.getUzbekistanPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getUzbekistanRegionByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(uzbekistanService.getUzbekistanPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<UzbekistanEntity>> getAllUzbekistanRegions() {
        return ResponseEntity.ok(uzbekistanService.getAllRegions());
    }
}
