package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.KyrgyzstanEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.KyrgyzstanService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/kyrgyzstan/plates")
public class KyrgyzstanController {

    private final KyrgyzstanService kyrgyzstanService;

    @GetMapping("/region/{region}")
    public ResponseEntity getKyrgyzstanPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(kyrgyzstanService.getKyrgyzstanPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getKyrgyzstanPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(kyrgyzstanService.getKyrgyzstanPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<KyrgyzstanEntity>> getAllKyrgyzstanRegions() {
        return ResponseEntity.ok(kyrgyzstanService.getAllRegions());
    }
}
