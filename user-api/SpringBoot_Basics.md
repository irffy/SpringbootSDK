# 🌱 Introduction to Spring Boot and REST Controllers

## 1. What is Spring Boot?

### 🧩 Definition

Spring Boot is a **framework for building web applications and REST APIs
in Java** --- quickly, with minimal configuration.

It's built on top of the **Spring Framework**, which is a huge Java
library for building enterprise-grade applications.

So Spring Boot is basically **Spring made simple**.\
It gives you: - An **embedded web server** (no need for separate Tomcat
installation) - **Auto-configuration** (less setup) - **Dependency
management** - **Production-ready tools** (metrics, health checks, etc.)

------------------------------------------------------------------------

### ⚙️ Analogy with Flask

  ----------------------------------------------------------------------------------
  Concept                Flask                    Spring Boot
  ---------------------- ------------------------ ----------------------------------
  Web framework          Flask                    Spring Boot

  Start server           `flask run`              `mvn spring-boot:run`

  Define route           `@app.route('/user')`    `@RestController`,
                                                  `@GetMapping("/user")`

  Return response        `return jsonify(data)`   `return ResponseEntity.ok(data)`
  ----------------------------------------------------------------------------------

So, think of Spring Boot as **Flask on steroids for Java** --- it
handles a lot of heavy lifting for you.

------------------------------------------------------------------------

### 🚀 Why is it popular?

1.  **Quick to build APIs** (few annotations, minimal boilerplate)
2.  **Runs standalone** --- you just run `java -jar app.jar`
3.  **Integrated dependency management** (via Maven/Gradle)
4.  **Scalable** --- you can start small, grow to enterprise scale
5.  **Built-in web server (Tomcat/Jetty)** --- no extra setup

------------------------------------------------------------------------

## 2. What is a REST API?

REST = **Representational State Transfer**

It's a design style for communication between **client** and **server**
using HTTP.

### Example REST Operations

  Operation   HTTP Method   URL              Description
  ----------- ------------- ---------------- -------------------
  Create      `POST`        `/api/users`     Create a new user
  Read        `GET`         `/api/users/1`   Get user details
  Update      `PUT`         `/api/users/1`   Update user
  Delete      `DELETE`      `/api/users/1`   Delete user

A **Spring Boot REST Controller** is what implements these APIs.

------------------------------------------------------------------------

## 3. What is a REST Controller?

A **controller** in Spring Boot is a Java class that handles incoming
HTTP requests and returns responses.

You mark it with annotations: - `@RestController` → Handles web requests
and returns data. - `@RequestMapping` → Base path (e.g., `/api/users`) -
`@GetMapping`, `@PostMapping` → Specific endpoints - `@RequestBody` →
Reads JSON input - `@PathVariable` → Extracts URL parts

### Example:

``` java
@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        return "User ID: " + id;
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        return "Created user: " + user.getName();
    }
}
```

------------------------------------------------------------------------

### 🔍 What happens internally?

1.  Spring Boot starts an embedded web server (Tomcat).
2.  When you hit `GET /api/users/1`, it finds the matching controller
    method.
3.  The `@PathVariable` extracts `1`.
4.  The method runs and returns data.
5.  Spring converts the response to JSON automatically (using Jackson).

------------------------------------------------------------------------

## 🧠 Important Core Concepts

  Concept              Description
  -------------------- --------------------------------------------
  **Controller**       Handles incoming HTTP requests
  **Service**          Business logic (optional layer)
  **Repository**       Database interaction layer
  **Model (Entity)**   Represents data (like Python class)
  **ResponseEntity**   Customizes HTTP response (status + body)
  **Jackson**          Converts Java objects ↔ JSON automatically

Typical layered flow:

    Controller → Service → Repository → Database

------------------------------------------------------------------------

## 🧠 Summary

  Term                             Meaning
  -------------------------------- ------------------------------------------------
  **Spring Boot**                  Framework for building Java-based APIs quickly
  **REST Controller**              Handles HTTP requests/responses
  **Mapping annotations**          Define which URL triggers which method
  **RequestBody / PathVariable**   Extract data from client requests
  **ResponseEntity**               Customize HTTP responses

------------------------------------------------------------------------

## ✅ Next Step

Next, we'll build a **POST /api/users** endpoint to accept and return
JSON data.
