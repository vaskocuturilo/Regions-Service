package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.PolandDiplomaticEntity;
import com.regions.simpleregions.exception.DescriptionNotFoundException;
import com.regions.simpleregions.exception.RegionNotFoundException;
import com.regions.simpleregions.model.PolandDiplomaticDescriptionModel;
import com.regions.simpleregions.model.PolandDiplomaticModel;
import com.regions.simpleregions.respository.PolandDiplomaticRepository;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.regions.simpleregions.util.DestinationCode.getDestinationCode;
import static com.regions.simpleregions.util.Utils.getFirstThreeSymbols;

@Log4j2
@Data
@Service
public class PolandDiplomaticService {

    private final PolandDiplomaticRepository polandDiplomaticRepository;

    @Value("${notification.region.message}")
    private String regionNotFound;

    @Value("${notification.description.message}")
    private String descriptionNotFound;

    @Cacheable(value = "poland_diplomatic_region", key = "#region")
    public PolandDiplomaticModel getPolandPlatesByRegion(final String region) throws RegionNotFoundException {
        log.info("Start method getPolandPlatesByRegion");

        Optional<PolandDiplomaticEntity> polandDiplomaticRegion = polandDiplomaticRepository.findByRegion(getFirstThreeSymbols(region));

        Optional.ofNullable(polandDiplomaticRegion.stream().parallel().filter(polandDiplomaticEntity -> polandDiplomaticEntity
                        .getRegion()
                        .equalsIgnoreCase(getFirstThreeSymbols(region)))
                .findFirst()
                .orElseThrow(() ->
                        new RegionNotFoundException(String.format(regionNotFound, region))));

        final String destinationCode = getDestinationCode(region);

        return PolandDiplomaticModel.toModel(polandDiplomaticRegion, destinationCode);
    }

    @Cacheable(value = "poland_diplomatic_description", key = "#description")
    public List<PolandDiplomaticDescriptionModel> getPolandRegionByDescription(final String description) throws DescriptionNotFoundException {
        log.info("Start method getPolandRegionByDescription");
        List<PolandDiplomaticEntity> polandEntityList = polandDiplomaticRepository.findByDescription(description);
        polandEntityList.stream().parallel().findAny().map(polandDiplomaticEntity -> polandDiplomaticEntity
                .getDescription()
                .equalsIgnoreCase(description)).orElseThrow(() -> new DescriptionNotFoundException(String.format(descriptionNotFound, description)));

        return polandEntityList.stream().map(PolandDiplomaticDescriptionModel::toDescription).toList();
    }

    public Iterable<PolandDiplomaticEntity> getAllRegions() {
        log.info("Start method getAllRegions");
        return polandDiplomaticRepository.findAll();
    }
}
