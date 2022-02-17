package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.ItalianEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.ItalianModel;
import com.regions.simpleRegions.respository.ItalianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItalianService {

    ItalianRepo italianRepo;

    @Autowired
    public ItalianService(ItalianRepo italianRepo) {
        this.italianRepo = italianRepo;
    }

    public ItalianModel getOne(String region) throws RegionNotFoundException {
        ItalianEntity italianRegion = italianRepo.findByRegion(region);
        if (italianRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return ItalianModel.toModel(italianRegion);
    }

    public Iterable<ItalianEntity> getAllRegions() {
        return italianRepo.findAll();
    }
}
