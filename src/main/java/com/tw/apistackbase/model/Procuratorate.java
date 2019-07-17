package com.tw.apistackbase.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "procuratorate")
public class Procuratorate {
    @Id
    @GeneratedValue
    private int id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @OneToMany
    @JoinColumn(name = "procuratorate_id")
    private List<Prosecutor> prosecutors;

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
