package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.KyrgyzstanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KyrgyzstanController {

    KyrgyzstanService kyrgyzstanService;

    public KyrgyzstanController(KyrgyzstanService kyrgyzstanService) {
        this.kyrgyzstanService = kyrgyzstanService;
    }

    @GetMapping("/kyrgyzstan")
    public ResponseEntity getKyrgyzstanRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(kyrgyzstanService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/kyrgyzstan/all")
    public ResponseEntity getAllKyrgyzstanRegions() {
        try {
            return ResponseEntity.ok(kyrgyzstanService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
