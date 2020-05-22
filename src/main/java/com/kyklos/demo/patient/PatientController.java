package com.kyklos.demo.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @RequestMapping("/hi")
    public ResponseEntity <String> sayHi() {
        return new ResponseEntity<>("Hi",HttpStatus.OK);
    }

    @GetMapping(path ="/patient")
     public ResponseEntity<ArrayList<Patient>> getAllCases() {
        return new ResponseEntity<>(patientService.getAllCases(), HttpStatus.OK);
    }

    @GetMapping(path = "/patient/lastname/{lastName}")
    ResponseEntity<ArrayList<Patient>> getCaseById(@PathVariable String lastName) {
        return new ResponseEntity<>(patientService.getCaseByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping(path = "/patient/{id}")
    ResponseEntity<Patient> getCaseById(@PathVariable Long id) {
        return new ResponseEntity<Patient>(patientService.getCaseById(id), HttpStatus.OK);
    }

    @PostMapping (path = "/patient")
    ResponseEntity<Patient> CreateCase(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.addCase(patient), HttpStatus.CREATED);
    }

    @PutMapping (path = "/patient")
    ResponseEntity<Patient> UpdateCase(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.updateCase(patient), HttpStatus.OK);
    }

    @DeleteMapping (path = "/patient/{id}")
    ResponseEntity<Void> DeleteCase(@PathVariable Long id) {
        patientService.deleteCase(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
