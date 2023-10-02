package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.ApiKeyEntity;
import com.regions.simpleregions.entity.User;
import com.regions.simpleregions.exception.UserException;
import com.regions.simpleregions.respository.ApiKeyRepository;
import com.regions.simpleregions.respository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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

    public ApiKeyEntity createApiKey(User userId) {
        final Optional<User> optionalUser = userRepository.findById(userId.getId());

        if (optionalUser.isEmpty()) {
            throw new UserException("Not Found", HttpStatus.NOT_FOUND);
        }

        final ApiKeyEntity apiKeyEntity = new ApiKeyEntity();

        apiKeyEntity.setApiKey(ApiKeyHelpService.createApiKey().get());
        apiKeyEntity.setExpires(new Date(System.currentTimeMillis() + EXPIRY_INTERVAL));

        apiKeyEntity.setUser(userId);
        apiKeyRepository.save(apiKeyEntity);

        return apiKeyEntity;
    }

    @Transactional
    public void deleteByApiKey(Integer code) {
        apiKeyRepository.deleteByApiKey(code);
    }
}
