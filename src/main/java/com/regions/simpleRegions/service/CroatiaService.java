package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.CroatiaEntity;
import com.regions.simpleRegions.exception.RegionNotFoundException;
import com.regions.simpleRegions.model.CroatiaModel;
import com.regions.simpleRegions.respository.CroatiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CroatiaService {

    CroatiaRepository croatiaRepository;

    @Autowired
    public CroatiaService(CroatiaRepository croatiaRepository) {
        this.croatiaRepository = croatiaRepository;
    }

    public CroatiaModel getOne(String region) throws RegionNotFoundException {
        CroatiaEntity croatiaRegion = croatiaRepository.findByRegion(region);
        if (croatiaRegion == null) {
            throw new RegionNotFoundException("Region not found.");
        }
        return CroatiaModel.toModel(croatiaRegion);
    }

    public Iterable<CroatiaEntity> getAllRegions() {
        return croatiaRepository.findAll();
    }
}
