package com.kyklos.demo.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CasesController {

    @Autowired
    CasesService casesService;

    @RequestMapping("/hi")
    public ResponseEntity <String> sayHi() {
        return new ResponseEntity<>("Hi",HttpStatus.OK);
    }

    @GetMapping(path ="/cases")
     public ResponseEntity<ArrayList<Cases>> getAllCases() {
        return new ResponseEntity<>(casesService.getAllCases(), HttpStatus.OK);
    }

    @GetMapping(path = "/cases/{id}")
    ResponseEntity<Cases> getCaseById(@PathVariable Long id) {
        return new ResponseEntity<Cases>(casesService.getCaseById(id), HttpStatus.OK);
    }

    @PostMapping (path = "/cases")
    ResponseEntity<Cases> CreateCase(@RequestBody Cases cases) {
        return new ResponseEntity<>(casesService.addCase(cases), HttpStatus.CREATED);
    }

    @PutMapping (path = "/cases")
    ResponseEntity<Cases> UpdateCase(@RequestBody Cases cases) {
        return new ResponseEntity<>(casesService.updateCase(cases), HttpStatus.OK);
    }

    @DeleteMapping (path = "/cases/{id}")
    ResponseEntity<Void> DeleteCase(@PathVariable Long id) {
        casesService.deleteCase(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
