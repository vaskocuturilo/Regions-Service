package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.entity.RussiaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.service.RussiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/regions")
public class RussiaController {

    @Autowired
    RussiaService russiaService;

    public ResponseEntity createRegion(@RequestBody RussiaEntity russia) {
        try {
            russiaService.createRegion(russia);
            return ResponseEntity.ok("Region is saved.");
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(russiaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
