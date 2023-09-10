package com.regions.simpleregions.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
public class RussiaDiplomaticEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    @Size(min = 2, max = 4, message = "Min 2, Max 4")
    @NotEmpty(message = "Field is mandatory")
    @NotBlank(message = "Field is mandatory")
    private String region;

    @Column(nullable = false)
    @Size(min = 2, max = 30, message = "Min 2, Max 30")
    @NotEmpty(message = "Field is mandatory")
    @NotBlank(message = "Field is mandatory")
    private String description;
}
