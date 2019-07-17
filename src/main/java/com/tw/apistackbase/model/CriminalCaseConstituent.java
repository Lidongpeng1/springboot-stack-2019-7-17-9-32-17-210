package com.tw.apistackbase.model;

import javax.persistence.*;

@Entity
@Table(name = "criminal_case_constituent")
public class CriminalCaseConstituent {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String objectiveDescription;

    @Column(nullable = false)
    private String subjectiveDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjectiveDescription() {
        return objectiveDescription;
    }

    public void setObjectiveDescription(String objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
    }

    public String getSubjectiveDescription() {
        return subjectiveDescription;
    }

    public void setSubjectiveDescription(String subjectiveDescription) {
        this.subjectiveDescription = subjectiveDescription;
    }
}
