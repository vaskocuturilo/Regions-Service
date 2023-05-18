package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.BritishAgeEntity;
import com.regions.simpleRegions.exception.DateRegistrationException;
import com.regions.simpleRegions.model.BritishAgeModel;
import com.regions.simpleRegions.respository.BritishAgeIdentifierRepo;
import lombok.Data;

@Data
public class BritishAgeService {
    BritishAgeIdentifierRepo britishAgeIdentifierRepo;

    public BritishAgeModel getOne(String code) throws DateRegistrationException {
        BritishAgeEntity ageIdentifierRepoByAge = britishAgeIdentifierRepo.findByCode(code);
        if (ageIdentifierRepoByAge == null) {
            throw new DateRegistrationException("Date of registration not found.");
        }
        return BritishAgeModel.toModel(ageIdentifierRepoByAge);
    }

    public Iterable<BritishAgeEntity> getAllRegions() {
        return britishAgeIdentifierRepo.findAll();
    }
}
