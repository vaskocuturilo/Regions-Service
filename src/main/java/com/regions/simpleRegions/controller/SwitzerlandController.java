package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.SwitzerlandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SwitzerlandController {

    SwitzerlandService switzerlandService;

    public SwitzerlandController(SwitzerlandService switzerlandService) {
        this.switzerlandService = switzerlandService;
    }

    @GetMapping("/switzerland")
    public ResponseEntity getSwitzerlandRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(switzerlandService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/switzerland/all")
    public ResponseEntity getAllSwitzerlandRegions() {
        try {
            return ResponseEntity.ok(switzerlandService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
