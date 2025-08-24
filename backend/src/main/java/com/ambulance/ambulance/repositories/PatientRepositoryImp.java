package com.ambulance.ambulance.repositories;

import com.ambulance.ambulance.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepositoryImp {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Patient savePatient(Patient patient){
        Patient savedPatient = mongoTemplate.save(patient);
        return savedPatient;
    }
}
