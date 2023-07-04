package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.LithuaniaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.LithuaniaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/lithuania/plates")
public class LithuaniaController {

    private final LithuaniaService lithuaniaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getLithuaniaPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(lithuaniaService.getLithuaniaPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getLithuaniaPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(lithuaniaService.getLithuaniaPlatesByDescription(description));
        } catch (DescriptionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<LithuaniaEntity>> getAllLithuaniaRegions() {
        return ResponseEntity.ok(lithuaniaService.getAllRegions());
    }
}
