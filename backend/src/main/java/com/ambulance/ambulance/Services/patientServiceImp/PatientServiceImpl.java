package com.ambulance.ambulance.Services.patientServiceImp;

import com.ambulance.ambulance.Services.PatientService;
import com.ambulance.ambulance.entities.Patient;
import com.ambulance.ambulance.repositories.PatientRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service("patientDetailsService")
public class PatientServiceImpl implements PatientService, UserDetailsService {

    private final PatientRepositoryImp patientRepositoryImp;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PatientServiceImpl(PatientRepositoryImp patientRepositoryImp,
                              PasswordEncoder passwordEncoder) {
        this.patientRepositoryImp = patientRepositoryImp;
        this.passwordEncoder = passwordEncoder;
    }




    @Override
    public Patient createPatient(Patient patient) {
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        patient.setTime(LocalDateTime.now());
        return patientRepositoryImp.savePatient(patient);
    }

    @Override
    public Patient getPatient(String email) {
        return patientRepositoryImp.findPatientByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Patient patient = patientRepositoryImp.findPatientByEmail(email);
        if(patient != null){
            return org.springframework.security.core.userdetails.User.builder()
                    .username(patient.getEmail())
                    .password(patient.getPassword())
                    .roles("PATIENT")
                    .build();
        }
        throw new UsernameNotFoundException("User not found with email "+email);
    }
}