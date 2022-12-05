package com.example.jee_jpa.model;

import jakarta.persistence.*;

@Entity
public class Game {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    //CONSTRUCTEURS
    public Game(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Game(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Game() {

    }

    //GETTER AND SETTER
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
