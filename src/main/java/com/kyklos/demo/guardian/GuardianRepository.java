package com.kyklos.demo.guardian;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface GuardianRepository extends CrudRepository<Guardian, Long> {

    ArrayList<Guardian> getGuardianByLastNameIsContaining(String lastName);
}
