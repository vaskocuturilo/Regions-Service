package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.NorwayEntity;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.NorwayModel;
import com.regions.simpleregions.respository.NorwayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NorwayService {

    NorwayRepo norwayRepo;

    @Autowired
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
