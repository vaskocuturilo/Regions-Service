package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.RussiaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.RussiaDiplomaticService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("http://localhost:3000/")
@Log4j2
@RestController
@RequestMapping("/api/v1/russia/diplomatic/plates")
@Data
public class RussiaDiplomaticController {

    private final RussiaDiplomaticService russiaDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getRussiaDiplomaticPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(russiaDiplomaticService.getRussiaDiplomaticPlatesByRegion(region));
        } catch (final RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("description/{description}")
    public ResponseEntity getRussiaDiplomaticPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(russiaDiplomaticService.getRussiaDiplomaticPlatesByDescription(description));
        } catch (final DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<RussiaDiplomaticEntity>> getAllRussiaDiplomaticRegions() {
        return ResponseEntity.ok(russiaDiplomaticService.getAllDiplomaticRegions());
    }
}
