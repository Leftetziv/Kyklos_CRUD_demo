package com.kyklos.demo.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service
public class CasesService {

        @Autowired
        private CasesRepo casesRepo;

        public ArrayList<Cases> getAllCases() {
            ArrayList<Cases> list = new ArrayList<>();
            casesRepo.findAll().forEach(list::add);
            return list;
        }

        public ArrayList<Cases> getCaseByLastName(String lastName) {
            ArrayList<Cases> list = new ArrayList<>();
            casesRepo.getCasesByLastNameIsContaining(lastName).forEach(list::add);
            return list;
        }

        public Cases getCaseById(Long id) {
            try {
                return casesRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));
            } catch (EntityNotFoundException e) {
                return new Cases();
            }
        }

        public Cases addCase(Cases Cases) {
            return casesRepo.save(Cases);
        }

        public Cases updateCase(Cases Cases) {
            return casesRepo.save(Cases);
        }

        public void deleteCase(Long id) {
            casesRepo.deleteById(id);
        }
    
}
