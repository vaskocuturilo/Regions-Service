package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.FranceDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.FranceDiplomaticService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("http://localhost:3000/")
@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/france/diplomatic/plates")
public class FranceDiplomaticController {
    private final FranceDiplomaticService franceDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getFranceDiplomaticPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(franceDiplomaticService.getFranceDiplomaticPlatesByRegion(region));
        } catch (final RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getFranceDiplomaticPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(franceDiplomaticService.getFranceDiplomaticPlatesByDescription(description));
        } catch (final DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<FranceDiplomaticEntity>> getAllFranceDiplomaticRegions() {
        return ResponseEntity.ok(franceDiplomaticService.getAllDiplomaticRegions());
    }
}
