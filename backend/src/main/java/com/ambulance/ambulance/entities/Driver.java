package com.ambulance.ambulance.entities;


import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "driver-entries")
public class Driver {
    @Id

    private String id;
    private String fullName;
    private String email;
    private String password;
    private String vehicalNumber;
    private String licence;
    private String role;

    public @NonNull String getVehicalNumber() {
        return vehicalNumber;
    }

    public void setVehicalNumber(@NonNull String carNumber) {
        this.vehicalNumber = carNumber;
    }

    public @NonNull String getRole() {
        return role;
    }

    public void setRole(@NonNull String role) {
        this.role = role;
    }

    public @NonNull String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        if (licence != null && !licence.trim().isEmpty()) {
            this.licence = licence;
        } else {
            throw new IllegalArgumentException("Licence cannot be null or empty");
        }
    }

    public @NonNull String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public @NonNull String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public @NonNull String getFullName() {
        return fullName;
    }

    public void setFullName(@NonNull String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
