package com.regions.simpleregions.controller;

import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.exception.RegionsNotFoundException;
import com.regions.simpleregions.service.KyrgyzstanService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/v1/kyrgyzstan/plates")
public class KyrgyzstanController {

    private final KyrgyzstanService kyrgyzstanService;

    @GetMapping("/region/{region}")
    public ResponseEntity getKyrgyzstanPlatesByRegion(@PathVariable String region) {
        try {
            return ResponseEntity.ok(kyrgyzstanService.getKyrgyzstanPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getKyrgyzstanPlatesByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(kyrgyzstanService.getKyrgyzstanPlatesByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllKyrgyzstanRegions() {
        try {
            return ResponseEntity.ok(kyrgyzstanService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
