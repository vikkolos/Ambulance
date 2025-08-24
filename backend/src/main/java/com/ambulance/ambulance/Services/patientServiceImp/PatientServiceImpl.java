package com.ambulance.ambulance.Services.patientServiceImp;

import com.ambulance.ambulance.Services.PatientService;
import com.ambulance.ambulance.entities.Patient;
import com.ambulance.ambulance.repositories.PatientRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService, UserDetailsService {

    @Autowired
    private PatientRepositoryImp patientRepositoryImp;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Patient createPatient(Patient patient) {
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        return patientRepositoryImp.savePatient(patient);
    }

    @Override
    public Patient getPatient(String email){
        return patientRepositoryImp.findPatientByEmail(email);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Patient patient = patientRepositoryImp.findPatientByEmail(email);
        if(patient != null){
            return org.springframework.security.core.userdetails.User.builder()
                    .username(patient.getFullName())
                    .password(patient.getPassword())
                    .build();
        }
        throw new UsernameNotFoundException("User not found with email "+email);
    }
}
