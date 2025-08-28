
package com.ambulance.ambulance.controllers;

import com.ambulance.ambulance.Services.DriverService;
import com.ambulance.ambulance.entities.Driver;
import com.ambulance.ambulance.utils.Jwtutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.BindException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/driver")
public class PublicDriverController {

    @Autowired
    private  DriverService driverService;
    @Autowired
    private  Jwtutility jwtutil;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Driver driver){
            Driver isDriverExist = driverService.getDriver(driver.getEmail());
            if(isDriverExist != null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error" , "User already exist"));
            }
            Driver driverResponse = driverService.createDriver(driver);
            String jwt = jwtutil.generateToken(driverResponse.getEmail());
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("jwt", jwt);
            responseData.put("driver", driverResponse);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseData);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Driver driver) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(driver.getEmail(), driver.getPassword())
            );

            Driver existingDriver = driverService.getDriver(driver.getEmail());
            String jwt = jwtutil.generateToken(existingDriver.getEmail());

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("jwt", jwt);
            responseData.put("driver", existingDriver);

            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Incorrect email or password"));
        }
    }
}