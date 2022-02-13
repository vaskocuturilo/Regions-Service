package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.CroatiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CroatiaController {

    CroatiaService croatiaService;

    public CroatiaController(CroatiaService croatiaService) {
        this.croatiaService = croatiaService;
    }

    @GetMapping("/croatia")
    public ResponseEntity getCroatiaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(croatiaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/croatia/all")
    public ResponseEntity getAllCroatiaRegions() {
        try {
            return ResponseEntity.ok(croatiaService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
