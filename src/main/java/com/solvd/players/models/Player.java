package com.solvd.players.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "players")
public class Player {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int rate;
    @Column
    private String team;
    @Column
    private String url;

    public Player(String name, String surname, int rate,String team,String url) {
        this.name = name;
        this.surname = surname;
        this.rate = rate;
        this.team=team;
        this.url=url;
    }

    public Player() {
    }
}
