package com.api.institutional_app.entity;

import lombok.Getter;
import lombok.Setter;

import com.api.institutional_app.util.Status;

import jakarta.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

}
