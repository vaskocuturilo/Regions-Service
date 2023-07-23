package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.PolandDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.PolandDiplomaticService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("http://localhost:3000/")
@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/poland/diplomatic/plates")
public class PolandDiplomaticController {

    private final PolandDiplomaticService polandDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getPolandPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(polandDiplomaticService.getPolandPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getPolandRegionByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(polandDiplomaticService.getPolandRegionByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<PolandDiplomaticEntity>> getAllPolandRegions() {
        return ResponseEntity.ok(polandDiplomaticService.getAllRegions());
    }
}
