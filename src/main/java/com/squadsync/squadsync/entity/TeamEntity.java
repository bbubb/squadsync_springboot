package com.squadsync.squadsync.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<PlayerEntity> playerEntities = new ArrayList<>();

}
