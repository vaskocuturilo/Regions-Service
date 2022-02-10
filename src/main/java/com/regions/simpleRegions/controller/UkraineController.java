package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.service.UkraineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UkraineController {

    UkraineService ukraineService;

    public UkraineController(UkraineService ukraineService) {
        this.ukraineService = ukraineService;
    }

    @GetMapping("/ukraine")
    public ResponseEntity getUkraineRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(ukraineService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/ukraine/all")
    public ResponseEntity getAllUkraineRegions() {
        try {
            return ResponseEntity.ok(ukraineService.getAllRegions());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
