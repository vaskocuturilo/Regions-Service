package com.regions.simpleregions.service;

import com.regions.simpleregions.dtos.SignUpDto;
import com.regions.simpleregions.dtos.UserDto;
import com.regions.simpleregions.entity.User;
import com.regions.simpleregions.exception.UserException;
import com.regions.simpleregions.model.CredentialsDto;
import com.regions.simpleregions.model.UserMapper;
import com.regions.simpleregions.respository.UserRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.login())
                .orElseThrow(() -> new UserException("Unknown user", HttpStatus.NOT_FOUND));

        throw new UserException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {
        Optional<User> optionalUser = userRepository.findByLogin(userDto.login());

        if (optionalUser.isPresent()) {
            throw new UserException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword("");

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UserException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }
}
