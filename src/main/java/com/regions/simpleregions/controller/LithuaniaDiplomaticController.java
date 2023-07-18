package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.LithuaniaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.LithuaniaDiplomaticService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/lithuania/diplomatic/plates")
public class LithuaniaDiplomaticController {

    private final LithuaniaDiplomaticService lithuaniaDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getLithuaniaDiplomaticPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(lithuaniaDiplomaticService.getLithuaniaDiplomaticPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getLithuaniaDiplomaticPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(lithuaniaDiplomaticService.getLithuaniaDiplomaticPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<LithuaniaDiplomaticEntity>> getAllLithuaniaDiplomaticRegions() {
        return ResponseEntity.ok(lithuaniaDiplomaticService.getAllLithuaniaDiplomaticRegions());
    }
}
