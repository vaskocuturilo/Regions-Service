package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.MalaysiaDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.MalaysiaDiplomaticModel;
import com.regions.simpleregions.respository.MalaysiaDiplomaticRepository;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Data
@Service
public class MalaysiaDiplomaticService {

    private final MalaysiaDiplomaticRepository malaysiaDiplomaticRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "montenegro_diplomatic_region", key = "#region")
    public MalaysiaDiplomaticModel getMalaysiaDiplomaticPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getMontenegroDiplomaticPlatesByRegion");
        Optional<MalaysiaDiplomaticEntity> malaysiaRegion = malaysiaDiplomaticRepository.findByRegion(region);

        Optional.ofNullable(malaysiaRegion.stream().parallel().filter(malaysiaDiplomaticEntity -> malaysiaDiplomaticEntity.getRegion().equalsIgnoreCase(region))
                .findFirst()
                .orElseThrow(() -> new RegionNotFoundException(String.format(regionNotFound, region))));

        return MalaysiaDiplomaticModel.toModelByRegion(malaysiaRegion);
    }

    @Cacheable(value = "montenegro_diplomatic_description", key = "#description")
    public List<MalaysiaDiplomaticModel> getMalaysiaDiplomaticPlatesByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getMontenegroDiplomaticPlatesByDescription");
        List<MalaysiaDiplomaticEntity> malaysiaEntityList = malaysiaDiplomaticRepository.findByDescription(description);

        malaysiaEntityList.stream().parallel().map(montenegroEntity -> montenegroEntity
                        .getDescription()
                        .equalsIgnoreCase(description))
                .findAny()
                .orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return malaysiaEntityList.stream().map(MalaysiaDiplomaticModel::toModelByDescription).toList();
    }

    public Iterable<MalaysiaDiplomaticEntity> getAllMalaysiaDiplomaticRegions() {
        log.info("Start method getAllMontenegroDiplomaticRegions");
        return malaysiaDiplomaticRepository.findAll();
    }
}
