package com.api.institutional_app.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "visitors")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 14, nullable = false)
    private String cpf;

    @Column(nullable = true)
    private String email;

    @OneToMany(mappedBy = "visitor")
    private List<Vote> votes;

}
