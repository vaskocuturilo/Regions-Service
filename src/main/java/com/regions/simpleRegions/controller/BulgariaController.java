package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.BulgariaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BulgariaController {

    BulgariaService bulgariaService;

    public BulgariaController(BulgariaService bulgariaService) {
        this.bulgariaService = bulgariaService;
    }

    @GetMapping("/bulgaria")
    public ResponseEntity getBulgariaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(bulgariaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/bulgaria/all")
    public ResponseEntity getAllBulgariaRegions() {
        try {
            return ResponseEntity.ok(bulgariaService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
