package com.api.institutional_app.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "institutes")
public class Institute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 14, nullable = false)
    private String cnpj;

    @Column(nullable = true)
    private Double locallat;

    @Column(nullable = true)
    private Double locallong;

    @OneToMany(mappedBy = "institute")
    private List<CoordinatorInstitute> coordinatorInstitutes;
}
