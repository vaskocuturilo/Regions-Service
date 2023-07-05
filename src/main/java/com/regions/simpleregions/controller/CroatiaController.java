package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.CroatiaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.CroatiaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/croatia/plates")
public class CroatiaController {

    private final CroatiaService croatiaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getCroatiaPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(croatiaService.getCroatiaPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getCroatiaPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(croatiaService.getCroatiaPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<CroatiaEntity>> getAllCroatiaRegions() {
        return ResponseEntity.ok(croatiaService.getAllRegions());
    }
}
