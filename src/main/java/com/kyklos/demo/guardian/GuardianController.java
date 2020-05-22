package com.kyklos.demo.guardian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class GuardianController {

    @Autowired
    GuardianService guardianService;

    @GetMapping(path ="/guardian")
     public ResponseEntity<ArrayList<Guardian>> getAllGuardian() {
        return new ResponseEntity<>(guardianService.getAllGuardian(), HttpStatus.OK);
    }

    @GetMapping(path = "/guardian/lastname/{lastName}")
    ResponseEntity<ArrayList<Guardian>> getGuardianById(@PathVariable String lastName) {
        return new ResponseEntity<>(guardianService.getGuardianByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping(path = "/guardian/{id}")
    ResponseEntity<Guardian> getGuardianById(@PathVariable Long id) {
        return new ResponseEntity<>(guardianService.getGuardianById(id), HttpStatus.OK);
    }

    @PostMapping (path = "/guardian")
    ResponseEntity<Guardian> CreateGuardian(@RequestBody Guardian guardian) {
        return new ResponseEntity<>(guardianService.addGuardian(guardian), HttpStatus.CREATED);
    }

    @PutMapping (path = "/guardian")
    ResponseEntity<Guardian> UpdateGuardian(@RequestBody Guardian guardian) {
        return new ResponseEntity<>(guardianService.updateGuardian(guardian), HttpStatus.OK);
    }

    @DeleteMapping (path = "/guardian/{id}")
    ResponseEntity<Void> DeleteGuardian(@PathVariable Long id) {
        guardianService.deleteGuardian(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
