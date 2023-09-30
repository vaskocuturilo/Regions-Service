package com.regions.simpleregions.service;

import com.regions.simpleregions.entity.OneTimePasswordEntity;
import com.regions.simpleregions.entity.User;
import com.regions.simpleregions.exception.UserException;
import com.regions.simpleregions.respository.OneTimePasswordRepository;
import com.regions.simpleregions.respository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OneTimePasswordService {
    private static final Long EXPIRY_INTERVAL = 5L * 60 * 1000;

    private final OneTimePasswordRepository oneTimePasswordRepository;
    private final UserRepository userRepository;

    public OneTimePasswordEntity createOneTimePassword(User userId) {
        Optional<User> optionalUser = userRepository.findById(userId.getId());

        if (optionalUser.isEmpty()) {
            throw new UserException("Not Found", HttpStatus.NOT_FOUND);
        }

        OneTimePasswordEntity oneTimePassword = new OneTimePasswordEntity();
        oneTimePassword.setOneTimePasswordCode(OneTimePasswordHelpService.createRandomOneTimePassword().get());
        oneTimePassword.setExpires(new Date(System.currentTimeMillis() + EXPIRY_INTERVAL));

        oneTimePassword.setUser(userId);
        oneTimePasswordRepository.save(oneTimePassword);


        return oneTimePassword;
    }

    @Transactional
    public void deleteByOneTimePasswordCode(Integer code) {
        oneTimePasswordRepository.deleteByOneTimePasswordCode(code);
    }
}
