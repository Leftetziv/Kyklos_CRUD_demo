package com.kyklos.demo.guardian;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kyklos.demo.patient.Patient;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties("protectedMembers")
public class Guardian {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "guardian")
    private Set<Patient> protectedMembers;

    public Guardian() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Patient> getProtectedMembers() {
        return protectedMembers;
    }

    public void setProtectedMembers(Set<Patient> protectedMembers) {
        this.protectedMembers = protectedMembers;
    }
}

