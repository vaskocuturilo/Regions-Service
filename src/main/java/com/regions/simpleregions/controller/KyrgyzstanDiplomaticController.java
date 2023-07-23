package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.KyrgyzstanDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.KyrgyzstanDiplomaticService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("http://localhost:3000/")
@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/kyrgyzstan/diplomatic/plates")
public class KyrgyzstanDiplomaticController {

    private final KyrgyzstanDiplomaticService kyrgyzstanDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getKyrgyzstanDiplomaticPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(kyrgyzstanDiplomaticService.getKyrgyzstanDiplomaticPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getKyrgyzstanDiplomaticPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(kyrgyzstanDiplomaticService.getKyrgyzstanDiplomaticPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<KyrgyzstanDiplomaticEntity>> getAllKyrgyzstanDiplomaticRegions() {
        return ResponseEntity.ok(kyrgyzstanDiplomaticService.getAllKyrgyzstanDiplomaticRegions());
    }
}
