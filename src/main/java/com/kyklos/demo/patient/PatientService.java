package com.kyklos.demo.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service
public class PatientService {

        @Autowired
        private PatientRepository PatientRepository;

        public ArrayList<Patient> getAllCases() {
            ArrayList<Patient> list = new ArrayList<>();
            PatientRepository.findAll().forEach(list::add);
            return list;
        }

        public ArrayList<Patient> getCaseByLastName(String lastName) {
            ArrayList<Patient> list = new ArrayList<>();
            PatientRepository.getCasesByLastNameIsContaining(lastName).forEach(list::add);
            return list;
        }

        public Patient getCaseById(Long id) {
            try {
                return PatientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));
            } catch (EntityNotFoundException e) {
                return new Patient();
            }
        }

        public Patient addCase(Patient Patient) {
            return PatientRepository.save(Patient);
        }

        public Patient updateCase(Patient Patient) {
            return PatientRepository.save(Patient);
        }

        public void deleteCase(Long id) {
            PatientRepository.deleteById(id);
        }
    
}
