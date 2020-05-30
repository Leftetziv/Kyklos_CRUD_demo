package com.kyklos.demo.patient;

import com.kyklos.demo.patient.queries.MedicalDescriptionSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PatientController {
 

    @Autowired
    PatientService patientService;

    @Autowired
    MedicalDescriptionSearch medicalDescriptionSearch;

    @Value("${custom.welcomeMsg}")
    String ServerReply;

    @RequestMapping("/hi")
    public ResponseEntity <String> ServerReply() {
        return new ResponseEntity<>(ServerReply,HttpStatus.OK);
    }

    @GetMapping(path ="/patient")
     public ResponseEntity<ArrayList<Patient>> getAllPatient() {
        return new ResponseEntity<>(patientService.getAllPatient(), HttpStatus.OK);
    }

    @GetMapping(path = "/patient/lastname/{lastName}")
    ResponseEntity<ArrayList<Patient>> getPatientByLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(patientService.getPatientByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping(path = "/patient/medicaldescription/{medicalDescription}")
    ResponseEntity<ArrayList<Patient>> getPatientByMedicalDescription(@PathVariable String medicalDescription) {
        return new ResponseEntity<>(medicalDescriptionSearch.getPatientByMedicalDescriptionSearch(medicalDescription), HttpStatus.OK);
    }

    @GetMapping(path = "/patient/{id}")
    ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return new ResponseEntity<Patient>(patientService.getPatientById(id), HttpStatus.OK);
    }

    @PostMapping (path = "/patient")
    ResponseEntity<Patient> CreatePatient(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.CREATED);
    }

    @PutMapping (path = "/patient")
    ResponseEntity<Patient> UpdatePatient(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.updatePatient(patient), HttpStatus.OK);
    }

    @DeleteMapping (path = "/patient/{id}")
    ResponseEntity<Void> DeletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
