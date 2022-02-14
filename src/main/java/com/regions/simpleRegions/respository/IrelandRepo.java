package com.regions.simpleRegions.respository;

import com.regions.simpleRegions.entity.IrelandEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrelandRepo extends CrudRepository<IrelandEntity, Long> {

    IrelandEntity findByRegion(String region);
}
