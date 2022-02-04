package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.service.IrelandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IrelandController {

    IrelandService irelandService;

    public IrelandController(IrelandService irelandService) {
        this.irelandService = irelandService;
    }

    @GetMapping("/ireland")
    public ResponseEntity getIrelandRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(irelandService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
