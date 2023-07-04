package com.regions.simpleregions.controller;


import com.regions.simpleregions.entity.KazakhstanEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.KazakhstanService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/kazakhstan/plates")
public class KazakhstanController {

    private final KazakhstanService kazakhstanService;

    @GetMapping("/region/{region}")
    public ResponseEntity getKazakhstanPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(kazakhstanService.getPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getKazakhstanPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(kazakhstanService.getPlatesByDescription(description));
        } catch (DescriptionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<KazakhstanEntity>> getAllKazakhstanRegions() {
        return ResponseEntity.ok(kazakhstanService.getAllRegions());
    }
}
