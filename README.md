# 🚑 Emergency Ambulance Booking System

A **responsive web application** designed to allow patients to **quickly book an ambulance** during medical emergencies and get connected to the **nearest hospital**. The system leverages **real-time location services** and **event-driven architecture** to ensure **fast and efficient ambulance dispatch**, reducing response time and improving patient outcomes.

## 🔧 Tech Stack

| Layer         | Technology Used         |
|---------------|--------------------------|
| Frontend      | React.js                 |
| Backend       | Java Spring Boot         |
| Real-Time Data| Apache Kafka             |
| Notifications | WebSockets               |
| Mapping       | Google Maps / Leaflet.js |
| Database      | MongoDB                  |
| Location API  | HTML5 Geolocation / GPS  |

---

## ✨ Key Features

- 🏥 **Emergency Ambulance Booking**: Patients can book an ambulance with a single click.
- 📍 **Real-time Location Tracking**: Live tracking of ambulance location via Kafka streams.
- ⚡ **Instant Driver Notifications**: Drivers receive emergency requests through WebSocket communication.
- 🧭 **Nearest Hospital Detection**: Automatically routes ambulance to the closest hospital.
- 📱 **Responsive UI**: Optimized for mobile devices.
- 📊 **Admin Dashboard**: Monitor all bookings, drivers, and response times (optional).

---


---

## 📁 Project Structure

│
├── frontend/ # React App
│ ├── public/
│ └── src/
│ ├── components/
│ ├── pages/
│ ├── services/
│ └── App.js
│
├── backend/ # Spring Boot App
│ └── src/main/java/com/app/
│ ├── controllers/
│ ├── services/
│ ├── models/
│ ├── config/
│ ├── entity/
│ ├── repository/
│ ├── websocket/ # WebSocket configs & handlers
│ └── kafka/ # Kafka producers & consumers
│
├── kafka/ # Kafka topic & broker config
├── docker-compose.yml # Docker config for dev environment
└── README.md

