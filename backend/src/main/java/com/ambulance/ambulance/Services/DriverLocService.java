package com.ambulance.ambulance.Services;
import com.ambulance.ambulance.entities.DriverLocation;
import com.ambulance.ambulance.repositories.DriverLocationRepo;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverLocService {

    private final DriverLocationRepo driverLocationRepo;

    public DriverLocService(DriverLocationRepo driverLocationRepo) {
        this.driverLocationRepo = driverLocationRepo;
    }

    public List<DriverLocation> findDriversWithin2Km(double userLongitude, double userLatitude) {
        double maxDistanceInMeters = 2000;

        return driverLocationRepo.findDriversNearLocation(
                userLongitude,
                userLatitude,
                maxDistanceInMeters
        );

    }

    public List<DriverLocation> findDriversWithinDistance(
            double userLongitude,
            double userLatitude,
            double distanceInKm
    ) {
        double maxDistanceInMeters = distanceInKm * 1000;
        return driverLocationRepo.findDriversNearLocation(
                userLongitude,
                userLatitude,
                maxDistanceInMeters
        );
    }
}
