package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.MoldovaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MoldovaController {

    MoldovaService moldovaService;

    public MoldovaController(MoldovaService moldovaService) {
        this.moldovaService = moldovaService;
    }

    @GetMapping("/moldova")
    public ResponseEntity getMoldovaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(moldovaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/moldova/all")
    public ResponseEntity getAllMoldovaRegions() {
        try {
            return ResponseEntity.ok(moldovaService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
