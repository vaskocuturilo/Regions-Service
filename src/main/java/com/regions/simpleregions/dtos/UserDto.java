package com.regions.simpleregions.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String login;
    private String token;
    private String oneTimePassword;
}
