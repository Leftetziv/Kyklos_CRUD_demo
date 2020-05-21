package com.kyklos.demo.cases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cases {

    @Id
    @GeneratedValue
    private Long id;

    private String surName;
    private String lastName;
    private String medicalDescription;
    private String generalComments;

    public Cases() {
    }

    public Cases(String surName, String lastName, String medicalDescription, String generalComments) {
        this.surName = surName;
        this.lastName = lastName;
        this.medicalDescription = medicalDescription;
        this.generalComments = generalComments;
    }

    public Cases(Long id, String surName, String lastName, String medicalDescription, String generalComments) {
        this.id = id;
        this.surName = surName;
        this.lastName = lastName;
        this.medicalDescription = medicalDescription;
        this.generalComments = generalComments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMedicalDescription() {
        return medicalDescription;
    }

    public void setMedicalDescription(String medicalDescription) {
        this.medicalDescription = medicalDescription;
    }

    public String getGeneralComments() {
        return generalComments;
    }

    public void setGeneralComments(String generalComments) {
        this.generalComments = generalComments;
    }

}
