package com.regions.simpleregions.controller;

import com.regions.simpleregions.entity.MalaysiaEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.MalaysiaService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("http://localhost:3000/")
@Log4j2
@Data
@RestController
@RequestMapping("/api/v1/malaysia/plates")
public class MalaysiaController {

    private final MalaysiaService malaysiaService;

    @GetMapping("/region/{region}")
    public ResponseEntity getMalaysiaPlatesByRegion(@Valid final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(malaysiaService.getMalaysiaPlatesByRegion(region));
        } catch (final RegionNotFoundException | RuntimeException exception) {
            log.debug("RegionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getMalaysiaPlatesByDescription(@Valid final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(malaysiaService.getMalaysiaPlatesByDescription(description));
        } catch (final DescriptionNotFoundException | RuntimeException exception) {
            log.debug("DescriptionNotFoundException", exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<MalaysiaEntity>> getAllMalaysiaRegions() {
        return ResponseEntity.ok(malaysiaService.getAllRegions());
    }
}
