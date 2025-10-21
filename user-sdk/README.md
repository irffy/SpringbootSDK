# 🧩 User SDK with Java + Spring Boot REST API

This project demonstrates how to build a simple **Java SDK client** that interacts with a **Spring Boot REST API**.  
It covers setting up both backend and client, sending HTTP requests using **OkHttp**, and handling JSON responses.

---

## 🚀 Project Overview

### Components
1. **Spring Boot Application (Backend)**
   - Runs on `localhost:8080`
   - Exposes REST endpoints to manage users

2. **Java SDK (Client Application)**
   - Uses `OkHttp` to send API requests
   - Built using **Gradle** with Kotlin DSL (`build.gradle.kts`)
   - Demonstrates how an SDK interacts with a REST service

---

## ⚙️ Prerequisites

Make sure you have the following installed:
- **Java 17**

```bash
java --version
```

Example Output:

```
openjdk 17.0.16 2025-07-15
OpenJDK Runtime Environment Temurin-17.0.16+8 (build 17.0.16+8)
OpenJDK 64-Bit Server VM Temurin-17.0.16+8 (build 17.0.16+8, mixed mode, sharing)
```

## ⚙️ Project Structure:
Projects-Dev/
├── user-api/              # Spring Boot backend
│   ├── src/main/java/...  # REST controller & model
│   └── build.gradle.kts
│
└── user-sdk/              # Java SDK client
    ├── src/main/java/...  # OkHttp client code
    └── build.gradle.kts

| Method | Endpoint          | Description     | Example Payload                                       |
| ------ | ----------------- | --------------- | ----------------------------------------------------- |
| `POST` | `/api/users`      | Create new user | `{"id":2,"name":"Irfan","email":"irfan@example.com"}` |
| `GET`  | `/api/users/{id}` | Get user by ID  | —                                                     |
Example GET http://localhost:8080/api/users/2 response:

{
  "id": 2,
  "name": "Irfan",
  "email": "irfan@example.com"
}

🧩 SDK Functionality

The SDK performs:

A POST request to create a user.

A GET request to fetch that same user.

Prints logs showing request/response cycle using OkHttp’s built-in logging.

Example output:

Created user: User(id=2, name=Irfan, email=irfan@example.com)
Fetched user: User(id=2, name=Irfan, email=irfan@example.com)

🛠️ How to Run

Start the Spring Boot API

cd user-api
./gradlew bootRun


Run the Java SDK

cd ../user-sdk
./gradlew clean run


Expected Output

Created user: User(id=2, name=Irfan, email=irfan@example.com)
Fetched user: User(id=2, name=Irfan, email=irfan@example.com)

🧠 Concepts Learned

How REST APIs expose endpoints using Spring Boot

How SDKs communicate using HTTP methods (GET, POST)

How to send and receive JSON using OkHttp

How to organize projects using Gradle
