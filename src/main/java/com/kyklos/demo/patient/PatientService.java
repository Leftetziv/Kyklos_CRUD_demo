package com.kyklos.demo.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service
public class PatientService {

        @Autowired
        private PatientRepository PatientRepository;

        public ArrayList<Patient> getAllPatient() {
            ArrayList<Patient> list = new ArrayList<>();
            PatientRepository.findAll().forEach(list::add);
            return list;
        }

        public ArrayList<Patient> getPatientByLastName(String lastName) {
            ArrayList<Patient> list = new ArrayList<>();
            PatientRepository.getPatientByLastNameIsContaining(lastName).forEach(list::add);
            return list;
        }

        public Patient getPatientById(Long id) {
            try {
                return PatientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));
            } catch (EntityNotFoundException e) {
                return new Patient();
            }
        }

        public Patient addPatient(Patient Patient) {
            return PatientRepository.save(Patient);
        }

        public Patient updatePatient(Patient Patient) {
            return PatientRepository.save(Patient);
        }

        public void deletePatient(Long id) {
            PatientRepository.deleteById(id);
        }
    
}
