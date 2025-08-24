package com.ambulance.ambulance.repositories;

import com.ambulance.ambulance.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;



@Repository
public class PatientRepositoryImp {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Patient savePatient(Patient patient){
        Patient savedPatient = mongoTemplate.save(patient);
        return savedPatient;
    }
    public Patient findPatientByEmail(String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        return mongoTemplate.findOne(query, Patient.class);
    }
}
