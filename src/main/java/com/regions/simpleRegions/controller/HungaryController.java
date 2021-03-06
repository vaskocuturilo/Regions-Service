package com.regions.simpleRegions.controller;


import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.HungaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HungaryController {

    HungaryService hungaryService;

    public HungaryController(HungaryService hungaryService) {
        this.hungaryService = hungaryService;
    }

    @GetMapping("/hungary")
    public ResponseEntity getHungaryRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(hungaryService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/hungary/all")
    public ResponseEntity getAllHungaryRegions() {
        try {
            return ResponseEntity.ok(hungaryService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
