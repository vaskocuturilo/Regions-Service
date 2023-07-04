package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.GermanyDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.GermanyDiplomaticService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/germany/diplomatic/plates")
public class GermanyDiplomaticController {

    private final GermanyDiplomaticService germanyDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getGermanPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(germanyDiplomaticService.getGermanPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getGermanPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(germanyDiplomaticService.getGermanPlatesByDescription(description));
        } catch (DescriptionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<GermanyDiplomaticEntity>> getAllGermanRegions() {
        return ResponseEntity.ok(germanyDiplomaticService.getAllRegions());
    }
}
