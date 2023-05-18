package com.regions.simpleRegions.controller;

import com.regions.simpleRegions.exception.DateRegistrationException;
import com.regions.simpleRegions.service.BritishAgeService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class BritishAgeController {
    BritishAgeService britishAgeService;

    @GetMapping("/british/date/number")
    public ResponseEntity getBritishAgeByCode(@RequestParam String code) {
        try {
            return ResponseEntity.ok(britishAgeService.getOne(code));
        } catch (DateRegistrationException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/british/date/all")
    public ResponseEntity getAllBritishDates() {
        try {
            return ResponseEntity.ok(britishAgeService.getAllRegions());
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
