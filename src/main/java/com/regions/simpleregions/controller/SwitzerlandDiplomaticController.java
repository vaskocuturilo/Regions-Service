package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.SwitzerlandDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.SwitzerlandDiplomaticService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("http://localhost:3000/")
@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/switzerland/diplomatic/plates")
public class SwitzerlandDiplomaticController {

    private final SwitzerlandDiplomaticService switzerlandDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getSwitzerlandDiplomaticPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(switzerlandDiplomaticService.getSwitzerlandDiplomaticPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getSwitzerlandDiplomaticPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(switzerlandDiplomaticService.getSwitzerlandDiplomaticPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<SwitzerlandDiplomaticEntity>> getAllSwitzerlandDiplomaticRegions() {
        return ResponseEntity.ok(switzerlandDiplomaticService.getAllSwitzerlandDiplomaticRegions());
    }
}
