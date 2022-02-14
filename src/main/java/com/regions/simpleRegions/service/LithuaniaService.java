package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.LithuaniaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.LithuaniaModel;
import com.regions.simpleRegions.respository.LithuaniaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LithuaniaService {

    LithuaniaRepo lithuaniaRepo;

    @Autowired
    public LithuaniaService(LithuaniaRepo lithuaniaRepo) {
        this.lithuaniaRepo = lithuaniaRepo;
    }

    public LithuaniaModel getOne(String region) throws RegionNotFoundException {
        LithuaniaEntity lithuaniaRegion = lithuaniaRepo.findByRegion(region);
        if (lithuaniaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return LithuaniaModel.toModel(lithuaniaRegion);
    }

}
