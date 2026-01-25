# Java Servlet Web Application with Thymeleaf

A simple Java web application built with **Jetty**, **Servlets**, and **Thymeleaf** as part of my system development studies.

The project demonstrates how to set up a lightweight web server, handle HTTP requests with servlets, and render HTML templates dynamically.

---

## Features

- Lightweight **Jetty server** running on port 8080.  
- Handles HTTP GET requests via **Servlets**.  
- Renders dynamic HTML pages using **Thymeleaf**.  
- Example of form submission with query parameters and URL path variables.  
- Simple layered design separating server setup, servlets, and template engine configuration.

---

## Technologies Used

- Java 17+  
- Jetty 9  
- Java Servlets (javax.servlet)  
- Thymeleaf 3.x  
- Maven for build and dependency management  
- Log4j2 for logging

---

## Project Structure
´´´

se.iths.sofia
├── Main.java # Starts the Jetty server and registers servlets
├── RootServlet.java # Handles requests to the root path "/"
├── HelloServlet.java # Handles requests to "/hello" and "/hello/*"
├── ThymeleafConfig.java # Configures Thymeleaf template engine
└── resources
├── templates # HTML templates (index.html, hello.html)
└── static # Optional static files (CSS, JS)


´´´
