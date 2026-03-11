package com.test.countries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cities")
public class City {
    @Id
    private Long id;
    @Column
    private String name;
    @Column(name = "country_id")
    private Long countryId;
}
