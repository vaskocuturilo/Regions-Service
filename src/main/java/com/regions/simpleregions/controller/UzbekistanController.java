package com.regions.simpleregions.controller;


import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.exception.RegionsNotFoundException;
import com.regions.simpleregions.service.UzbekistanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UzbekistanController {

    UzbekistanService uzbekistanService;

    public UzbekistanController(UzbekistanService uzbekistanService) {
        this.uzbekistanService = uzbekistanService;
    }

    @GetMapping("/uzbekistan")
    public ResponseEntity getUzbekistanRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(uzbekistanService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/uzbekistan/all")
    public ResponseEntity getAllUzbekistanRegions() {
        try {
            return ResponseEntity.ok(uzbekistanService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
