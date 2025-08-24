package com.ambulance.ambulance.controllers;


import com.ambulance.ambulance.Services.PatientService;
import com.ambulance.ambulance.entities.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        Patient patientResponse = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientResponse);
    }

}
