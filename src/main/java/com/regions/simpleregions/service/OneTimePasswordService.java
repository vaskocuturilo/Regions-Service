package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.OneTimePasswordEntity;
import com.regions.simpleregions.entity.User;
import com.regions.simpleregions.respository.OneTimePasswordRepository;
import com.regions.simpleregions.respository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class OneTimePasswordService {
    private static final Long EXPIRY_INTERVAL = 5L * 60 * 1000;

    private final OneTimePasswordRepository oneTimePasswordRepository;

    private final UserRepository userRepository;

    public OneTimePasswordService(OneTimePasswordRepository oneTimePasswordRepository, UserRepository userRepository) {
        this.oneTimePasswordRepository = oneTimePasswordRepository;
        this.userRepository = userRepository;
    }

    public OneTimePasswordEntity returnOneTimePassword(UUID userId) {
        OneTimePasswordEntity oneTimePassword = new OneTimePasswordEntity();
        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new IllegalStateException(String.format("The %s not found.", user));
        }

        oneTimePassword.setOneTimePasswordCode(OneTimePasswordHelpService.createRandomOneTimePassword().get());
        oneTimePassword.setExpires(new Date(System.currentTimeMillis() + EXPIRY_INTERVAL));

        oneTimePassword.setUser(user.get());
        oneTimePasswordRepository.save(oneTimePassword);

        return oneTimePassword;
    }

    @Transactional
    public void deleteByOneTimePasswordCode(Integer code) {
        oneTimePasswordRepository.deleteByOneTimePasswordCode(code);
    }
}
