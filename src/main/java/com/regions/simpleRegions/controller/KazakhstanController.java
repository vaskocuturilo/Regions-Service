package com.regions.simpleRegions.controller;


import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.service.KazakhstanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KazakhstanController {

    KazakhstanService kazakhstanService;

    public KazakhstanController(KazakhstanService kazakhstanService) {
        this.kazakhstanService = kazakhstanService;
    }

    @GetMapping("/kazakhstan")
    public ResponseEntity getKazakhstanRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(kazakhstanService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
