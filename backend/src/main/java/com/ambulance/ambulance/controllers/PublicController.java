package com.ambulance.ambulance.controllers;


import com.ambulance.ambulance.Services.PatientService;
import com.ambulance.ambulance.Services.patientServiceImp.PatientServiceImpl;
import com.ambulance.ambulance.entities.Patient;

import com.ambulance.ambulance.utils.Jwtutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PublicController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientServiceImpl patientServiceImpl;

    @Autowired
    private Jwtutility jwtutil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<Patient> signup(@RequestBody Patient patient) {
        Patient patientResponse = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Patient patient) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(patient.getEmail(), patient.getPassword())
            );
            Patient exixtingPatient =patientServiceImpl.getPatient(patient.getEmail());
            String jwt = jwtutil.generateToken(exixtingPatient.getFullName());
            Map<String,Object> responseData = new HashMap<>();
            responseData.put("jwt",jwt);
            responseData.put("Patient",exixtingPatient);

            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Incorrect username or password");
        }
    }
}
