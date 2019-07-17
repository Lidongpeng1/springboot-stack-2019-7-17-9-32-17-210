package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
@Table(name = "criminal_case")
public class CriminalCase {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long time;

    @OneToOne
    @JoinColumn(name = "constituent_id")
    private CriminalCaseConstituent criminalCaseConstituent;

    @OneToOne
    @JoinColumn(name = "procuratorate_id", nullable = false)
    private Procuratorate procuratorate;

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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public CriminalCaseConstituent getCriminalCaseConstituent() {
        return criminalCaseConstituent;
    }

    public void setCriminalCaseConstituent(CriminalCaseConstituent criminalCaseConstituent) {
        this.criminalCaseConstituent = criminalCaseConstituent;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }
}
