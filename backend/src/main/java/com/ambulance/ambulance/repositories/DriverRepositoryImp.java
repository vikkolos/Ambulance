package com.ambulance.ambulance.repositories;


import com.ambulance.ambulance.entities.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class DriverRepositoryImp {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Driver saveDriver(Driver driver){
        return mongoTemplate.save(driver);
    }

    public Driver findDriverByEmail(String email){
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        return mongoTemplate.findOne(query,Driver.class);
    }

}
