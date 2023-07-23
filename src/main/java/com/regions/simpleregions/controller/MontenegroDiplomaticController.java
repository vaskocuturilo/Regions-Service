package com.regions.simpleregions.controller;


import com.regions.simpleregions.entity.MontenegroDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.MontenegroDiplomaticService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("http://localhost:3000/")
@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/montenegro/diplomatic/plates")
public class MontenegroDiplomaticController {

    private final MontenegroDiplomaticService montenegroDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getMontenegroDiplomaticPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(montenegroDiplomaticService.getMontenegroDiplomaticPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getMontenegroDiplomaticPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(montenegroDiplomaticService.getMontenegroDiplomaticPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<MontenegroDiplomaticEntity>> getAllMontenegroDiplomaticRegions() {
        return ResponseEntity.ok(montenegroDiplomaticService.getAllMontenegroDiplomaticRegions());
    }
}
