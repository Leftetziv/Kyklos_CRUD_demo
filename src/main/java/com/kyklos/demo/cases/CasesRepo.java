package com.kyklos.demo.cases;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CasesRepo extends CrudRepository<Cases, Long> {

    public ArrayList<Cases> getCasesByLastName(String lastName);
}
