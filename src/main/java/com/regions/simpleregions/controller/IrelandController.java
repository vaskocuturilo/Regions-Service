package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.IrelandEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.IrelandService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/ireland/plates")
public class IrelandController {

    private final IrelandService irelandService;

    @GetMapping("/region/{region}")
    public ResponseEntity getIrelandPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(irelandService.getPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getIrelandPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(irelandService.getPlatesByDescription(description));
        } catch (DescriptionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<IrelandEntity>> getAllIrelandRegions() {
        return ResponseEntity.ok(irelandService.getAllRegions());
    }
}
