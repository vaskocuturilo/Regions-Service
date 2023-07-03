package com.regions.simpleregions.controller;

import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.exception.RegionsNotFoundException;
import com.regions.simpleregions.service.AzerbaijanService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/v1/azerbaijan/plates")
public class AzerbaijanController {

    private final AzerbaijanService azerbaijanService;

    @GetMapping("/region/{region}")
    public ResponseEntity getAzerbaijanRegionByNumber(@PathVariable String region) {
        try {
            return ResponseEntity.ok(azerbaijanService.getRegionByNumber(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getAzerbaijanRegionByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(azerbaijanService.getRegionByDescription(description));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllAzerbaijanRegions() {
        try {
            return ResponseEntity.ok(azerbaijanService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

}
