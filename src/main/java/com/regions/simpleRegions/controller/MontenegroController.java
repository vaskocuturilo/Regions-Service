package com.regions.simpleRegions.controller;


import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.MontenegroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MontenegroController {

    MontenegroService montenegroService;

    public MontenegroController(MontenegroService montenegroService) {
        this.montenegroService = montenegroService;
    }

    @GetMapping("/montenegro")
    public ResponseEntity getMontenegroRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(montenegroService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/montenegro/all")
    public ResponseEntity getAllMontenegroRegions() {
        try {
            return ResponseEntity.ok(montenegroService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
