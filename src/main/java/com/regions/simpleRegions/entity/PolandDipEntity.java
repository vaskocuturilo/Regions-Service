package com.regions.simpleRegions.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PolandDipEntity {

    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    public class PolandEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String region;
        private String description;
    }

}
