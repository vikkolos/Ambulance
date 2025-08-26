# 👋 Welcome to the Ambulance Management System – API Docs

This guide gives you the lowdown on how to get started with our app’s **sign-up** and **log-in** functionality for both **Patients** and **Drivers**.

It’s simple and straightforward – let’s jump right in! 🚀

---

## 🌐 Base URL


All endpoints below are relative to this base URL.

---

## 🧑‍⚕️ Patient APIs

### 🔹 Patient Sign-Up

Need a new patient account? No problem! Just send a POST request with your full name, email, and password.

- **Endpoint:** `/patient/signup`  
- **Method:** `POST`

#### 📨 Request Body

```json
{
  "fullName": "kamal",
  "email": "kamal@gmail.com",
  "password": "yourpassword"
}
```
### 📬 Response Example
```
{
  "jwt": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9...",
  "patient": {
    "id": "68acd40a7e97840d7c73cf98",
    "fullName": "kamal",
    "email": "kamal@gmail.com",
    "role": "PATIENT"
  }
}
```
### 🔹 Patient Log-In

Already have an account? Great! Just log in to get your JWT token – you’ll need it for all the cool stuff on the app.

- **Endpoint:** : /patient/login

- **Method:** : POST

### 📨 Request Body
```
{
  "email": "kamal@gmail.com",
  "password": "yourpassword"
}
```

## 📬 Response Example
```
{
  "jwt": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9...",
  "patient": {
    "id": "68acd40a7e97840d7c73cf98",
    "fullName": "kamal",
    "email": "kamal@gmail.com",
    "role": "PATIENT"
  }
}
```
## 🚗 Driver APIs
## 🔹 Driver Sign-Up

If you're a driver, this is your spot! Sign up with your personal and vehicle details.

- **Endpoint:** : /driver/signup

- **Method:** : POST
```
📨 Request Body
{
  "fullName": "Rahul kr",
  "email": "rahul@gmail.com",
  "password": "yourpassword",
  "vehicleNumber": "BR56HK7845",
  "licence": "HJ46546JHVJH"
}
```

## 📬 Response Example
```
{
  "driver": {
    "id": "68acca286b3b95cb7315c095",
    "fullName": "Rahul kr",
    "email": "rahul@gmail.com",
    "password": "$2a$10$...",
    "vehicleNumber": "BR56HK7845",
    "licence": "HJ46546JHVJH",
    "role": "DRIVER"
  },
  "jwt": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9..."
}
```
## 🔹 Driver Log-In

Time to hit the road! Log in and get your token to start accessing the driver features.

- **Endpoint:** : /driver/login

- **Method:** : POST
```
📨 Request Body
{
  "email": "rahul@gmail.com",
  "password": "yourpassword"
}
```

## 📬 Response Example
``` 
{
  "driver": {
    "id": "68acca286b3b95cb7315c095",
    "fullName": "Rahul kr",
    "email": "rahul@gmail.com",
    "vehicleNumber": "BR56HK7845",
    "licence": "HJ46546JHVJH",
    "role": "DRIVER"
  },
  "jwt": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9..."
}
```