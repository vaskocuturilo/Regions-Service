package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.AustriaDiplomaticEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.AustriaDiplomaticService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/austria/diplomatic/plates")
public class AustriaDiplomaticController {
    private final AustriaDiplomaticService austriaDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity<?> getAustriaPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(austriaDiplomaticService.getAustriaPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<?> getAustriaPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(austriaDiplomaticService.getAustriaPlatesByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<AustriaDiplomaticEntity>> getAllAustriaRegions() {
        return ResponseEntity.ok(austriaDiplomaticService.getAllRegions());
    }
}
