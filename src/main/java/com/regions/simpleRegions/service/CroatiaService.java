package com.regions.simpleRegions.service;

import com.regions.simpleRegions.entity.CroatiaEntity;
import com.regions.simpleRegions.exception.RegionsNotFoundException;
import com.regions.simpleRegions.model.CroatiaModel;
import com.regions.simpleRegions.respository.CroatiaRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class CroatiaService {
    private final CroatiaRepo croatiaRepo;

    public CroatiaModel getRegionByName(String region) {
        Optional<CroatiaEntity> croatiaRegion = croatiaRepo.findByRegion(region);
        croatiaRegion.stream().filter(croatiaEntity -> croatiaEntity.getRegion().equals(region)).findFirst().orElseThrow(
                () -> {
                    RegionsNotFoundException regionsNotFoundException = new RegionsNotFoundException(String.format("Region with %s not found in database.", region));
                    return regionsNotFoundException;
                });

        return CroatiaModel.toModelRegion(croatiaRegion);
    }

    public List<CroatiaModel> getRegionByDescription(String description) throws RegionsNotFoundException {
        List<CroatiaEntity> croatiaEntities = croatiaRepo.findByDescription(description);

        if (croatiaEntities.isEmpty())
            throw new RegionsNotFoundException("Description with " + description + " not found in database.");

        return croatiaEntities.stream().map(CroatiaModel::toModelDescription).collect(Collectors.toList());
    }

    public Iterable<CroatiaEntity> getAllRegions() {
        return croatiaRepo.findAll();
    }
}
