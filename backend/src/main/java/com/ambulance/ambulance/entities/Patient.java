package com.ambulance.ambulance.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "patient-entries")
public class Patient {

    @Id
    private String id;
    private String fullName;
    private String email;
    private String password;
    private String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NonNull String getFullName() {
        return fullName;
    }

    public void setFullName(@NonNull String fullName) {
        this.fullName = fullName;
    }

    public @NonNull String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public @NonNull String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
    public @NonNull String getRole() {
        return role;
    }

    public void setRole(@NonNull String role) {
        this.role = role;
    }
}
