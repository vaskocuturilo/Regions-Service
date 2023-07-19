package com.regions.simpleregions.model;

import com.regions.simpleregions.dtos.SignUpDto;
import com.regions.simpleregions.dtos.UserDto;
import com.regions.simpleregions.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);
}
