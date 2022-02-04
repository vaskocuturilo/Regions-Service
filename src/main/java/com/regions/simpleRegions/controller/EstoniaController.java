package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.service.EstoniaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EstoniaController {

    EstoniaService estoniaService;

    public EstoniaController(EstoniaService estoniaService) {
        this.estoniaService = estoniaService;
    }

    @GetMapping("/estonia")
    public ResponseEntity getEstoniaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(estoniaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
