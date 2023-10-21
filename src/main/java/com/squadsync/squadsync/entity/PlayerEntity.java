package com.squadsync.squadsync.entity;

import jakarta.persistence.*;

@Entity
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity teamEntity;

}
