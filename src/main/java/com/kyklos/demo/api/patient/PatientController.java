package com.kyklos.demo.api.patient;

import com.kyklos.demo.api.patient.queries.MedicalDescriptionSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PatientController {

//    hasRole('ROLE_') hasAnyRole('ROLE_') hasAuthority('permission') hasAnyAuthority('permission')

    @Autowired
    PatientService patientService;

    @Autowired
    MedicalDescriptionSearch medicalDescriptionSearch;

    @Value("${custom.welcomeMsg}")
    String ServerReply;

    @RequestMapping("/hi")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity <String> ServerReply() {
        return new ResponseEntity<>(ServerReply,HttpStatus.OK);
    }

    @RequestMapping("/adminhi")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity <String> ServerReplyAdmin() {
        return new ResponseEntity<>(ServerReply+" ADMIN",HttpStatus.OK);
    }

    @GetMapping(path ="/patient")
    @PreAuthorize("hasAnyAuthority('permission:read', 'permission:write')")
     public ResponseEntity<ArrayList<Patient>> getAllPatient() {
        return new ResponseEntity<>(patientService.getAllPatient(), HttpStatus.OK);
    }

    @GetMapping(path = "/patient/lastname/{lastName}")
    @PreAuthorize("hasAnyAuthority('permission:read', 'permission:write')")
    ResponseEntity<ArrayList<Patient>> getPatientByLastName(@PathVariable String lastName) {
        return new ResponseEntity<>(patientService.getPatientByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping(path = "/patient/medicaldescription/{medicalDescription}")
    @PreAuthorize("hasAnyAuthority('permission:read', 'permission:write')")
    ResponseEntity<ArrayList<Patient>> getPatientByMedicalDescription(@PathVariable String medicalDescription) {
        return new ResponseEntity<>(medicalDescriptionSearch.getPatientByMedicalDescriptionSearch(medicalDescription), HttpStatus.OK);
    }

    @GetMapping(path = "/patient/{id}")
    @PreAuthorize("hasAnyAuthority('permission:read', 'permission:write')")
    ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return new ResponseEntity<Patient>(patientService.getPatientById(id), HttpStatus.OK);
    }

    @PostMapping (path = "/patient")
    @PreAuthorize("hasAuthority('permission:write')")
    ResponseEntity<Patient> CreatePatient(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.CREATED);
    }

    @PutMapping (path = "/patient")
    @PreAuthorize("hasAuthority('permission:write')")
    ResponseEntity<Patient> UpdatePatient(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.updatePatient(patient), HttpStatus.OK);
    }

    @DeleteMapping (path = "/patient/{id}")
    @PreAuthorize("hasAuthority('permission:write')")
    ResponseEntity<Void> DeletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
