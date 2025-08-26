package com.ambulance.ambulance.repositories;


import com.ambulance.ambulance.entities.DriverLocation;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverLocationRepo extends MongoRepository<DriverLocation, String> {

    @Query("{ 'location': { $near: { $geometry: { type: 'Point', coordinates: [?0, ?1] }, $maxDistance: ?2 } } }")
    List<DriverLocation> findDriversNearLocation(double longitude, double latitude, double maxDistance);


    List<DriverLocation> findByLocationNear(Point point, Distance distance);
}