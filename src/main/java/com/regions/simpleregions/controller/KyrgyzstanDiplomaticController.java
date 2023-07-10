package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.KyrgyzstanDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.KyrgyzstanDiplomaticService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/kyrgyzstan/diplomatic/plates")
public class KyrgyzstanDiplomaticController {

    private final KyrgyzstanDiplomaticService kyrgyzstanDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getKyrgyzstanDiplomaticPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(kyrgyzstanDiplomaticService.getKyrgyzstanDiplomaticPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getKyrgyzstanDiplomaticPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(kyrgyzstanDiplomaticService.getKyrgyzstanDiplomaticPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<KyrgyzstanDiplomaticEntity>> getAllKyrgyzstanDiplomaticRegions() {
        return ResponseEntity.ok(kyrgyzstanDiplomaticService.getAllKyrgyzstanDiplomaticRegions());
    }
}
