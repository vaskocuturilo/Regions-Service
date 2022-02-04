package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.service.SloveniaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SloveniaController {

    SloveniaService sloveniaService;

    public SloveniaController(SloveniaService sloveniaService) {
        this.sloveniaService = sloveniaService;
    }

    @GetMapping("/slovenia")
    public ResponseEntity getSloveniaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(sloveniaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
