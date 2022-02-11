package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.service.GermanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GermanController {

    GermanService germanService;

    public GermanController(GermanService germanService) {
        this.germanService = germanService;
    }

    @GetMapping("/german")
    public ResponseEntity getGermanRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(germanService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/german/all")
    public ResponseEntity getAllGermanRegions() {
        try {
            return ResponseEntity.ok(germanService.getAllRegions());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
