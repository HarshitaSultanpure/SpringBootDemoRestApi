📌 Overview

This project is a Spring Boot REST API that processes input data and files.
It separates numbers and alphabets, finds the highest lowercase alphabet, checks for prime numbers, validates files, and returns structured JSON responses.

The API exposes two endpoints:

POST /bfhl → Processes data and returns a response with categorized values.

GET /bfhl → Returns an operation code for testing.

⚙️ Tech Stack

Java 17+

Spring Boot (Web, Spring MVC)

Maven

Postman / Swagger for testing

🚀 Features

Accepts JSON input with data (strings) and base64 encoded file.

Separates numbers and alphabets from the input.

Identifies the highest lowercase alphabet.

Detects if prime numbers exist in input.

Validates files and returns metadata (MIME type, size in KB).

Provides structured JSON responses.

📂 Project Structure
src/main/java/com/example/restApi
│
├── App.java                  # Main application
│
├── controller/
│   └── BfhlController.java   # API endpoints
│
├── model/
│   ├── BfhlRequest.java      # Request model
│   └── BfhlResponse.java     # Response model
│
└── service/
    └── BfhlService.java      # Business logic
