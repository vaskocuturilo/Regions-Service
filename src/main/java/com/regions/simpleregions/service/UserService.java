package com.regions.simpleregions.service;

import com.regions.simpleregions.dtos.CredentialsDto;
import com.regions.simpleregions.dtos.SignUpDto;
import com.regions.simpleregions.dtos.UserActiveDto;
import com.regions.simpleregions.dtos.UserDto;
import com.regions.simpleregions.entity.ApiKeyEntity;
import com.regions.simpleregions.entity.OneTimePasswordEntity;
import com.regions.simpleregions.entity.User;
import com.regions.simpleregions.exception.OneTimePasswordException;
import com.regions.simpleregions.exception.UserAlreadyActive;
import com.regions.simpleregions.exception.UserException;
import com.regions.simpleregions.model.UserMapper;
import com.regions.simpleregions.respository.OneTimePasswordRepository;
import com.regions.simpleregions.respository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    private final OneTimePasswordService oneTimePasswordService;

    private final OneTimePasswordRepository oneTimePasswordRepository;

    private final ApiKeyService apiKeyService;

    private static final String UNKNOWN_USER = "Unknown user";

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.login())
                .orElseThrow(() -> new UserException(UNKNOWN_USER, HttpStatus.NOT_FOUND));

        if (!user.isActive()) {
            throw new UserException("The user is not activated", HttpStatus.FORBIDDEN);
        }

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }

        throw new UserException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(final SignUpDto userDto) {
        final Optional<User> optionalUser = userRepository.findByLogin(userDto.login());

        if (optionalUser.isPresent()) {
            throw new UserException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        final User user = userMapper.signUpToUser(userDto);

        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.password())));

        final User savedUser = userRepository.save(user);

        final OneTimePasswordEntity oneTimePassword = oneTimePasswordService.createOneTimePassword(savedUser);

        final ApiKeyEntity apiKeyEntity = apiKeyService.createApiKey(savedUser);

        savedUser.setOneTimePassword(oneTimePassword);

        savedUser.setApiKey(apiKeyEntity);

        return userMapper.toUserDto(savedUser);
    }

    public UserActiveDto active(final Integer userId, final Integer code) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UNKNOWN_USER, HttpStatus.NOT_FOUND));

        Integer oneTimePasswordCodeExist = oneTimePasswordRepository.findByOneTimePasswordCode(userId);

        if (user.isActive()) {
            throw new UserAlreadyActive("The user is active now", HttpStatus.BAD_REQUEST);
        }
        if (!oneTimePasswordCodeExist.equals(code)) {
            throw new OneTimePasswordException("The code is incorrect", HttpStatus.NOT_FOUND);
        }

        user.setActive(true);

        final User savedUser = userRepository.save(user);

        oneTimePasswordService.deleteByOneTimePasswordCode(code);

        return userMapper.toUserActiveDto(savedUser);
    }


    public UserDto findByLogin(final String login) {
        final User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UserException(UNKNOWN_USER, HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }
}
