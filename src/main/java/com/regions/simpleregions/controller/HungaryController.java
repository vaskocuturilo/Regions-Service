package com.regions.simpleregions.controller;


import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.exception.RegionsNotFoundException;
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
    public ResponseEntity getHungaryRegionByNumber(@PathVariable String region) {
        try {
            return ResponseEntity.ok(hungaryService.getRegionByNumber(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }


    @GetMapping("/description/{description}")
    public ResponseEntity getHungaryRegionByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(hungaryService.getRegionByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllHungaryRegions() {
        try {
            return ResponseEntity.ok(hungaryService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
