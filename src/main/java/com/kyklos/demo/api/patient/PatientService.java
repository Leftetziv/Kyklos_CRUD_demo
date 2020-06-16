package com.kyklos.demo.api.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service
public class PatientService {

        @Autowired
        private PatientRepository patientRepository;

        public ArrayList<Patient> getAllPatient() {
            ArrayList<Patient> list = new ArrayList<>();
            patientRepository.findAll().forEach(list::add);
            return list;
        }

        public ArrayList<Patient> getPatientByLastName(String lastName) {
            ArrayList<Patient> list = new ArrayList<>();
            patientRepository.getPatientByLastNameIsContaining(lastName).forEach(list::add);
            return list;
        }

        public Patient getPatientById(Long id) {
            try {
                return patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));
            } catch (EntityNotFoundException e) {
                return new Patient();
            }
        }

        public Patient addPatient(Patient Patient) {
            return patientRepository.save(Patient);
        }

        public Patient updatePatient(Patient Patient) {
            return patientRepository.save(Patient);
        }

        public void deletePatient(Long id) {
            patientRepository.deleteById(id);
        }
    
}
