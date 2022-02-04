package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.service.FranceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FranceController {

    FranceService franceService;

    public FranceController(FranceService franceService) {
        this.franceService = franceService;
    }

    @GetMapping("/france")
    public ResponseEntity getFranceRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(franceService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
