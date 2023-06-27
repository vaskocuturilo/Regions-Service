package com.regions.simpleRegions.controller;


import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.KazakhstanService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/v1/kazakhstan/plates")
public class KazakhstanController {

    private final KazakhstanService kazakhstanService;

    @GetMapping("/region/{region}")
    public ResponseEntity getKazakhstanPlatesByRegion(@PathVariable String region) {
        try {
            return ResponseEntity.ok(kazakhstanService.getPlatesByRegion(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getKazakhstanPlatesByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(kazakhstanService.getPlatesByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllKazakhstanRegions() {
        try {
            return ResponseEntity.ok(kazakhstanService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
