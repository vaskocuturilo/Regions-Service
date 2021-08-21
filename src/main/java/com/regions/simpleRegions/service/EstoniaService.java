package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.EstoniaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.EstoniaModel;
import com.regions.simpleRegions.respository.EstoniaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoniaService {

    @Autowired
    EstoniaRepo estoniaRepo;

    public EstoniaModel getOne(String region) throws RegionNotFoundException {
        EstoniaEntity estoniaRegion = estoniaRepo.findByRegion(region);
        if (estoniaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return EstoniaModel.toModel(estoniaRegion);
    }
}
