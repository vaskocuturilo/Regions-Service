package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.NorwayDiplomaticEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.NorwayDiplomaticService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/norway/diplomatic/plates")
public class NorwayDiplomaticController {

    private final NorwayDiplomaticService norwayDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getNorwayDiplomaticPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(norwayDiplomaticService.getNorwayDiplomaticPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getNorwayDiplomaticPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(norwayDiplomaticService.getNorwayDiplomaticPlatesByDescription(description));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<NorwayDiplomaticEntity>> getAllNorwayDiplomaticRegions() {
        return ResponseEntity.ok(norwayDiplomaticService.getAllNorwayDiplomaticRegions());
    }
}
