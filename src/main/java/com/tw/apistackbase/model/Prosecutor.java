package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
@Table(name = "prosecutor")
public class Prosecutor {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
