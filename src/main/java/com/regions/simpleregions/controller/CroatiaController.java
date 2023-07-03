package com.regions.simpleregions.controller;

import com.regions.simpleregions.exception.RegionsNotFoundException;
import com.regions.simpleregions.service.CroatiaService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/croatia/plates")
public class CroatiaController {
    private final CroatiaService croatiaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getCroatiaRegionByNumber(@PathVariable String region) {
        try {
            return ResponseEntity.ok(croatiaService.getRegionByName(region));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getCroatiaRegionByDescription(@PathVariable String description) {
        try {
            return ResponseEntity.ok(croatiaService.getRegionByDescription(description));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
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
