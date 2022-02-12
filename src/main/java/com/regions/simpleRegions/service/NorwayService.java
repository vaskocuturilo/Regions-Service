package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.NorwayEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.NorwayModel;
import com.regions.simpleRegions.respository.NorwayRepo;
import org.springframework.stereotype.Service;

@Service
public class NorwayService {

    NorwayRepo norwayRepo;

    public NorwayService(NorwayRepo norwayRepo) {
        this.norwayRepo = norwayRepo;
    }

    public NorwayModel getOne(String region) throws RegionNotFoundException {
        NorwayEntity norwayRegion = norwayRepo.findByRegion(region);
        if (norwayRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return NorwayModel.toModel(norwayRegion);
    }

    public Iterable<NorwayEntity> getAllRegions(){
        return norwayRepo.findAll();
    }
}
