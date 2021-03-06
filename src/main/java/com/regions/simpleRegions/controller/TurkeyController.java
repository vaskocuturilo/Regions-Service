package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.TurkeyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TurkeyController {

    TurkeyService turkeyService;

    public TurkeyController(TurkeyService turkeyService) {
        this.turkeyService = turkeyService;
    }

    @GetMapping("/turkey")
    public ResponseEntity getTurkeyRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(turkeyService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/turkey/all")
    public ResponseEntity getAllTurkeyRegionsByNumber() {
        try {
            return ResponseEntity.ok(turkeyService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
