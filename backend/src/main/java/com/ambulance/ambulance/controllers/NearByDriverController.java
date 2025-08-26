package com.ambulance.ambulance.controllers;


import com.ambulance.ambulance.Services.DriverLocService;
import com.ambulance.ambulance.entities.DriverLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nearby")
public class NearByDriverController {
    @Autowired
    private DriverLocService driverLocService;

    @GetMapping
    public List<DriverLocation> getNearByDriver(@RequestParam double longitude,@RequestParam double latitude,@RequestParam(defaultValue = "2") double distance){
        return driverLocService.findDriversWithinDistance(longitude,latitude,distance);
    }
}
