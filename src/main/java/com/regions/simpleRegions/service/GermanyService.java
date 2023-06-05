package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.GermanyEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.GermanyModel;
import com.regions.simpleRegions.respository.GermanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GermanyService {

    GermanyRepo germanyRepo;

    @Autowired
    public GermanyService(GermanyRepo germanyRepo) {
        this.germanyRepo = germanyRepo;
    }

    public GermanyModel getRegionByNumber(String region) throws RegionNotFoundException {
        Optional<GermanyEntity> germanRegion = germanyRepo.findByRegion(region);
        if (!germanRegion.isPresent()) {
            throw new RegionNotFoundException("Region not found.");
        }
        return GermanyModel.toModelRegion(germanRegion);
    }

    public List<GermanyModel> getRegionByDescription(String region) throws RegionNotFoundException {
        List<GermanyModel> entityList = new ArrayList<>();
        List<GermanyEntity> germanRegion = germanyRepo.findByDescription(region);
        if (germanRegion.isEmpty()) {
            throw new RegionNotFoundException("Region not found.");
        }

        for (GermanyEntity germanyEntity : germanRegion) {
            entityList.add(GermanyModel.toModelDescription(germanyEntity));
        }

        return entityList;
    }

    public Iterable<GermanyEntity> getAllRegions() {
        return germanyRepo.findAll();
    }
}
