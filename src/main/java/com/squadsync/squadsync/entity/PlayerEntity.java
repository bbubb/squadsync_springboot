package com.squadsync.squadsync.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@Entity
public class PlayerEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;

//    @ManyToMany
//    @JoinTable(
//            name = "player_team",
//            joinColumns = @JoinColumn(name = "player_id"),
//            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<TeamEntity> teamEntities = new ArrayList<>();

}
