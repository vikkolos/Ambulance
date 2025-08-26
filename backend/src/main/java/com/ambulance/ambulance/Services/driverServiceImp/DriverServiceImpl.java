package com.ambulance.ambulance.Services.driverServiceImp;

import com.ambulance.ambulance.Services.DriverService;
import com.ambulance.ambulance.entities.Driver;
import com.ambulance.ambulance.repositories.DriverRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("driverDetailsService")
public class DriverServiceImpl implements DriverService, UserDetailsService {

    private final DriverRepositoryImp driverRepositoryImp;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DriverServiceImpl(DriverRepositoryImp driverRepositoryImp,
                             PasswordEncoder passwordEncoder) {
        this.driverRepositoryImp = driverRepositoryImp;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public Driver createDriver(Driver driver) {
        driver.setPassword(passwordEncoder.encode(driver.getPassword()));
        return driverRepositoryImp.saveDriver(driver);
    }

    @Override
    public Driver getDriver(String email) {
        return driverRepositoryImp.findDriverByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Driver driver = driverRepositoryImp.findDriverByEmail(email);
        if(driver != null){
            return org.springframework.security.core.userdetails.User.builder()
                    .username(driver.getEmail())
                    .password(driver.getPassword())
                    .roles("DRIVER")
                    .build();
        }
        throw new UsernameNotFoundException("User not found with email "+email);
    }
}