package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.CroatiaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.CroatiaDiplomaticService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/croatia/diplomatic/plates")
public class CroatiaDiplomaticController {

    private final CroatiaDiplomaticService croatiaDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getCroatiaDiplomaticPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(croatiaDiplomaticService.getCroatiaDiplomaticPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getCroatiaDiplomaticPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(croatiaDiplomaticService.getCroatiaDiplomaticPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<CroatiaDiplomaticEntity>> getAllCroatiaDiplomaticRegions() {
        return ResponseEntity.ok(croatiaDiplomaticService.getAllCroatiaDiplomaticRegions());
    }
}
