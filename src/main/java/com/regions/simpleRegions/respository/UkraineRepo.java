package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.RussiaEntity;
import com.regions.simpleRegions.entity.UkraineEntity;
import org.springframework.data.repository.CrudRepository;

public interface UkraineRepo extends CrudRepository<UkraineEntity, Long> {

    UkraineEntity findByRegion(String region);
}
