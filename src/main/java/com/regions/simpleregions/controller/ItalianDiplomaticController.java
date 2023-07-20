package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.ItalianDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.ItalianDiplomaticService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/api/v1/italian/diplomatic/plates")
@Data
public class ItalianDiplomaticController {
    private final ItalianDiplomaticService italianDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getItalianDiplomaticPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(italianDiplomaticService.getItalianDiplomaticPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getItalianDiplomaticPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(italianDiplomaticService.getItalianDiplomaticPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<ItalianDiplomaticEntity>> getAllItalianDiplomaticRegions() {
        return ResponseEntity.ok(italianDiplomaticService.getAllRegions());
    }
}
