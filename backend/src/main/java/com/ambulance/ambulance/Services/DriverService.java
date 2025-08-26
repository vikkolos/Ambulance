package com.ambulance.ambulance.Services;

import com.ambulance.ambulance.entities.Driver;
import com.ambulance.ambulance.entities.Patient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface DriverService {

    Driver createDriver(Driver driver);

    Driver getDriver(String email);

}
