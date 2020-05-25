package com.kyklos.demo.patient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kyklos.demo.guardian.Guardian;

import javax.persistence.*;
import java.util.Set;

@Entity
//@JsonIgnoreProperties ("guardian")
public class Patient {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String medicalDescription;
    private String generalComments;

    @ManyToOne
    @JoinColumn
    private Guardian guardian;

    public Patient() {
    }

    public Patient(Long id, String firstName, String lastName, String medicalDescription, String generalComments) {
        this.id = id;
        this.firstName = firstName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }
}
