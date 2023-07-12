package com.regions.simpleregions.controller;


import com.regions.simpleregions.entity.MontenegroDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.service.MontenegroDiplomaticService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/v1/montenegro/diplomatic/plates")
public class MontenegroDiplomaticController {

    private final MontenegroDiplomaticService montenegroDiplomaticService;

    @GetMapping("/region/{region}")
    public ResponseEntity getMontenegroDiplomaticPlatesByRegion(final @PathVariable("region") String region) {
        try {
            return ResponseEntity.ok(montenegroDiplomaticService.getMontenegroDiplomaticPlatesByRegion(region));
        } catch (RegionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/description/{description}")
    public ResponseEntity getMontenegroDiplomaticPlatesByDescription(final @PathVariable("description") String description) {
        try {
            return ResponseEntity.ok(montenegroDiplomaticService.getMontenegroDiplomaticPlatesByDescription(description));
        } catch (DescriptionNotFoundException | RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<MontenegroDiplomaticEntity>> getAllMontenegroDiplomaticRegions() {
        return ResponseEntity.ok(montenegroDiplomaticService.getAllMontenegroDiplomaticRegions());
    }
}
