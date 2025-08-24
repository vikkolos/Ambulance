package com.ambulance.ambulance.Services.patientServiceImp;

import com.ambulance.ambulance.Services.PatientService;
import com.ambulance.ambulance.entities.Patient;
import com.ambulance.ambulance.repositories.PatientRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepositoryImp patientRepositoryImp;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Patient createPatient(Patient patient) {
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        return patientRepositoryImp.savePatient(patient);
    }


}
