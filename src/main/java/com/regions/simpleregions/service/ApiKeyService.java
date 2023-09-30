package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.ApiKeyEntity;
import com.regions.simpleregions.entity.User;
import com.regions.simpleregions.respository.ApiKeyRepository;
import com.regions.simpleregions.respository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ApiKeyService {
    private static final Long EXPIRY_INTERVAL = 5L * 60 * 1000;

    private final ApiKeyRepository apiKeyRepository;

    private final UserRepository userRepository;

    public ApiKeyEntity getApiKeyByUser(Integer userId) {
        ApiKeyEntity apiKeyEntity = new ApiKeyEntity();
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new IllegalStateException(String.format("The %s not found.", user));
        }

        apiKeyEntity.setApiKey(ApiKeyHelpService.createApiKey().get());
        apiKeyEntity.setExpires(new Date(System.currentTimeMillis() + EXPIRY_INTERVAL));

        apiKeyEntity.setUser(user.get());
        apiKeyRepository.save(apiKeyEntity);

        return apiKeyEntity;
    }

    @Transactional
    public void deleteByApiKey(Integer code) {
        apiKeyRepository.deleteByApiKey(code);
    }
}
