package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.GermanyDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.GermanyDiplomaticService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/germany/diplomatic/plates")
public class GermanyDiplomaticController {

    private final GermanyDiplomaticService germanyDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getGermanPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(germanyDiplomaticService.getGermanPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getGermanPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(germanyDiplomaticService.getGermanPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());

        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<GermanyDiplomaticEntity>> getAllGermanRegions() {
        return ResponseEntity.ok(germanyDiplomaticService.getAllRegions());
    }
}
