package com.regions.simpleregions.controller;


import com.regions.simpleregions.entity.MontenegroEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.MontenegroService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/montenegro/plates")
public class MontenegroController {

    private final MontenegroService montenegroService;

    @GetMapping("/region/{region}")
    public ResponseEntity getMontenegroPlatesByRegion(@PathVariable String region) {
        try {
            return ResponseEntity.ok(montenegroService.getMontenegroPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getMontenegroPlatesByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(montenegroService.getMontenegroPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<MontenegroEntity>> getAllMontenegroRegions() {
        return ResponseEntity.ok(montenegroService.getAllRegions());
    }
}
