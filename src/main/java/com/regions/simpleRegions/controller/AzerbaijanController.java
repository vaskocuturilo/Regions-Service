package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.service.AzerbaijanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AzerbaijanController {

    AzerbaijanService azerbaijanService;

    public AzerbaijanController(AzerbaijanService azerbaijanService) {
        this.azerbaijanService = azerbaijanService;
    }

    @GetMapping("/azerbaijan")
    public ResponseEntity getAzerbaijanRegionByNumber(@RequestParam String region) {
        try {
            return ResponseEntity.ok(azerbaijanService.getOne(region));
        } catch (RegionNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
