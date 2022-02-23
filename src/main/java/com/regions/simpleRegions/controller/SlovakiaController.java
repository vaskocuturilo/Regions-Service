package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.SlovakiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SlovakiaController {

    SlovakiaService slovakiaService;

    public SlovakiaController(SlovakiaService slovakiaService) {
        this.slovakiaService = slovakiaService;
    }

    @GetMapping("/slovakia")
    public ResponseEntity getSlovakiaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(slovakiaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/slovakia/all")
    public ResponseEntity getAllSlovakiaRegions() {
        try {
            return ResponseEntity.ok(slovakiaService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
