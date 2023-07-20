package com.regions.simpleregions.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
public class PolandDiplomaticEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 6, max = 6, message = "Min 6, Max 6")
    @NotEmpty(message = "Field is mandatory")
    @NotBlank(message = "Field is mandatory")
    private String region;

    @Column(nullable = false)
    @Size(min = 2, max = 30, message = "Min 2, Max 30")
    @NotEmpty(message = "Field is mandatory")
    @NotBlank(message = "Field is mandatory")
    private String description;
}
