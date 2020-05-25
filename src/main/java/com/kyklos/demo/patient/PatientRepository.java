package com.kyklos.demo.patient;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PatientRepository extends CrudRepository<Patient, Long> {

    ArrayList<Patient> getPatientByLastNameIsContaining(String lastName);
}
