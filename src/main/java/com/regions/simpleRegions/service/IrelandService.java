package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.IrelandEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.IrelandModel;
import com.regions.simpleRegions.respository.IrelandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IrelandService {

    IrelandRepo irelandRepo;

    @Autowired
    public IrelandService(IrelandRepo irelandRepo) {
        this.irelandRepo = irelandRepo;
    }

    public IrelandModel getOne(String region) throws RegionNotFoundException {
        IrelandEntity irelandRegion = irelandRepo.findByRegion(region);
        if (irelandRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return IrelandModel.toModel(irelandRegion);
    }

    public Iterable<IrelandEntity> getAllRegions() {
        return irelandRepo.findAll();
    }
}
