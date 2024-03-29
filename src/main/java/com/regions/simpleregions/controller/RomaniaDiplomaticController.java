package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.RomaniaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.RomaniaDiplomaticService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("http://localhost:3000/")
@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/romania/diplomatic/plates")
public class RomaniaDiplomaticController {

    private final RomaniaDiplomaticService romaniaDiplomaticService;

    @GetMapping("/region/{region}")
    public Object getRomaniaDiplomaticPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(romaniaDiplomaticService.getRomaniaDiplomaticPlatesByRegion(region));
        } catch (final RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public Object getRomaniaDiplomaticPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(romaniaDiplomaticService.getRomaniaDiplomaticPlatesByDescription(description));
        } catch (final DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<RomaniaDiplomaticEntity>> getAllRomaniaDiplomaticRegions() {
        return ResponseEntity.ok(romaniaDiplomaticService.getAllRomaniaDiplomaticRegions());
    }
}
