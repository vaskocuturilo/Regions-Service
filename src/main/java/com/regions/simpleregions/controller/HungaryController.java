package com.regions.simpleregions.controller;


import com.regions.simpleregions.entity.HungaryEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.HungaryService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/hungary/plates")
public class HungaryController {

    private final HungaryService hungaryService;

    @GetMapping("/region/{region}")
    public ResponseEntity getHungaryPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(hungaryService.getHungaryPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }


    @GetMapping("/description/{description}")
    public ResponseEntity getHungaryPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(hungaryService.getHungaryPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<HungaryEntity>> getAllHungaryRegions() {
        return ResponseEntity.ok(hungaryService.getAllRegions());
    }
}
