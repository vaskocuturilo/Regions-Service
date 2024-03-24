package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.BritishAgeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BritishAgeRepository extends CrudRepository<BritishAgeEntity, Long> {
    Optional<BritishAgeEntity> findByCode(String code);
}
