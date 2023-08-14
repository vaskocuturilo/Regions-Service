package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.OneTimePasswordEntity;
import com.regions.simpleregions.entity.User;
import com.regions.simpleregions.respository.OneTimePasswordRepository;
import com.regions.simpleregions.respository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service

public class OneTimePasswordService {

    private final Long expiryInterval = 5L * 60 * 1000;

    private final OneTimePasswordRepository oneTimePasswordRepository;

    private final UserRepository userRepository;

    private OneTimePasswordHelpService oneTimePasswordHelpService;

    public OneTimePasswordService(OneTimePasswordRepository oneTimePasswordRepository, UserRepository userRepository) {
        this.oneTimePasswordRepository = oneTimePasswordRepository;
        this.userRepository = userRepository;
    }

    public OneTimePasswordEntity returnOneTimePassword(UUID userId) {
        OneTimePasswordEntity oneTimePassword = new OneTimePasswordEntity();
        User user = userRepository.findById(userId).get();

        oneTimePassword.setOneTimePasswordCode(oneTimePasswordHelpService.createRandomOneTimePassword().get());
        oneTimePassword.setExpires(new Date(System.currentTimeMillis() + expiryInterval));

        oneTimePassword.setUser(user);
        oneTimePasswordRepository.save(oneTimePassword);

        return oneTimePassword;
    }

    @Transactional
    public void deleteByOneTimePasswordCode(Integer code) {
        oneTimePasswordRepository.deleteByOneTimePasswordCode(code);
    }
}
