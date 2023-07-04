package com.regions.simpleregions.controller;


import com.regions.simpleregions.entity.HungaryEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.HungaryService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/v1/hungary/plates")
public class HungaryController {

    private final HungaryService hungaryService;

    @GetMapping("/region/{region}")
    public ResponseEntity getHungaryPlatesByRegion(final @PathVariable String region) {
        try {
            return ResponseEntity.ok(hungaryService.getHungaryPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }


    @GetMapping("/description/{description}")
    public ResponseEntity getHungaryPlatesByDescription(final @PathVariable String description) {
        try {
            return ResponseEntity.ok(hungaryService.getHungaryPlatesByDescription(description));
        } catch (DescriptionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<HungaryEntity>> getAllHungaryRegions() {
        return ResponseEntity.ok(hungaryService.getAllRegions());
    }
}
