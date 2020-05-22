package com.kyklos.demo.patient;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PatientRepository extends CrudRepository<Patient, Long> {

    ArrayList<Patient> getCasesByLastName(String lastName);
    ArrayList<Patient> getCasesByLastNameIsContaining(String lastName);
}
