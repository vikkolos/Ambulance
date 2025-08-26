package com.ambulance.ambulance.controllers;


import com.ambulance.ambulance.Services.PatientService;
import com.ambulance.ambulance.entities.Patient;

import com.ambulance.ambulance.utils.Jwtutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PublicPatientController {

    @Autowired
    private PatientService patientService;


    @Autowired
    private Jwtutility jwtutil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Patient patient) {
        Patient isPatientExist = patientService.getPatient(patient.getEmail());
        if(isPatientExist != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exist");
        }
        Patient patientResponse = patientService.createPatient(patient);
        String jwt = jwtutil.generateToken(patientResponse.getEmail());
        Map<String,Object> responseData = new HashMap<>();
        responseData.put("jwt",jwt);
        responseData.put("Patient",patientResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Patient patient) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(patient.getEmail(), patient.getPassword())
            );

            Patient existingPatient = patientService.getPatient(patient.getEmail());
            String jwt = jwtutil.generateToken(existingPatient.getEmail());
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("jwt", jwt);
            responseData.put("patient", existingPatient);

            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Incorrect email or password"));
        }
    }
}
