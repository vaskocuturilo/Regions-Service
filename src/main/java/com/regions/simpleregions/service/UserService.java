package com.regions.simpleregions.service;

import com.regions.simpleregions.dtos.CredentialsDto;
import com.regions.simpleregions.dtos.SignUpDto;
import com.regions.simpleregions.dtos.UserDto;
import com.regions.simpleregions.entity.OneTimePasswordEntity;
import com.regions.simpleregions.entity.User;
import com.regions.simpleregions.exception.UserException;
import com.regions.simpleregions.model.UserMapper;
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

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.login())
                .orElseThrow(() -> new UserException("Unknown user", HttpStatus.NOT_FOUND));

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

        savedUser.setOneTimePassword(oneTimePassword);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByLogin(final String login) {
        final User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UserException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }
}
