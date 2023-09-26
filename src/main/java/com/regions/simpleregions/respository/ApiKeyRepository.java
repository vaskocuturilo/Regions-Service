package com.regions.simpleregions.respository;

import com.regions.simpleregions.entity.ApiKeyEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ApiKeyRepository extends CrudRepository<ApiKeyEntity, UUID> {
    @Query("SELECT key.ApiKeyEntity FROM ApiKeyRepository key WHERE key.user.id = ?1")
    Integer findByApiKey(final UUID id);

    @Modifying
    @Query("delete from ApiKeyEntity key where key.apiKey = :code")
    void deleteByApiKey(final Integer code);
}
