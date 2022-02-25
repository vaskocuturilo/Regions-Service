package com.regions.simpleRegions.controller;


import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.SwedenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SwedenController {

    SwedenService swedenService;

    public SwedenController(SwedenService swedenService) {
        this.swedenService = swedenService;
    }

    @GetMapping("/sweden")
    public ResponseEntity getSwedenRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(swedenService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/sweden/all")
    public ResponseEntity getAllSwedenRegions() {
        try {
            return ResponseEntity.ok(swedenService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
