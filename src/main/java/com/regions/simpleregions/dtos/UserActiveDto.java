package com.regions.simpleregions.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class UserActiveDto {
    private String firstName;
    private String lastName;
    private String login;
    private boolean active;
}
