package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.service.LithuaniaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LithuaniaController {

    LithuaniaService lithuaniaService;

    public LithuaniaController(LithuaniaService lithuaniaService) {
        this.lithuaniaService = lithuaniaService;
    }

    @GetMapping("/lithuania")
    public ResponseEntity getLithuaniaRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(lithuaniaService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/lithuania/all")
    public ResponseEntity getAllLithuaniaRegions() {
        try {
            return ResponseEntity.ok(lithuaniaService.getAllRegions());
        } catch (RegionsNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
