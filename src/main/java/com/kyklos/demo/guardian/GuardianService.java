package com.kyklos.demo.guardian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service
public class GuardianService {

        @Autowired
        private GuardianRepository GuardianRepository;

        public ArrayList<Guardian> getAllGuardian() {
            ArrayList<Guardian> list = new ArrayList<>();
            GuardianRepository.findAll().forEach(list::add);
            return list;
        }

        public ArrayList<Guardian> getGuardianByLastName(String lastName) {
            ArrayList<Guardian> list = new ArrayList<>();
            GuardianRepository.getGuardianByLastNameIsContaining(lastName).forEach(list::add);
            return list;
        }

        public Guardian getGuardianById(Long id) {
            try {
                return GuardianRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found"));
            } catch (EntityNotFoundException e) {
                return new Guardian();
            }
        }

        public Guardian addGuardian(Guardian guardian) {
            return GuardianRepository.save(guardian);
        }

        public Guardian updateGuardian(Guardian guardian) {
            return GuardianRepository.save(guardian);
        }

        public void deleteGuardian(Long id) {
            GuardianRepository.deleteById(id);
        }
    
}
