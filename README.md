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


🔑 API Endpoints


1️⃣ Health Check

GET /bfhl

✅ Response
{
  "operation_code": 1
}

2️⃣ Process Data

POST /bfhl

📥 Request Body
{
  "data": ["A", "b", "3", "9", "z"],
  
  "file_b64": "base64encodedstring..."
}

✅ Response Example

{
  "is_success": true,
  
  "user_id": "john_doe_17091999",
  
  "email": "john.doe@example.com",
  
  "roll_number": "AB123",
  
  "numbers": ["3", "9"],
  
  "alphabets": ["A", "b", "z"],
  
  "highest_lowercase_alphabet": ["z"],
  
  "is_prime_found": true,
  
  "file_valid": true,
  
  "file_mime_type": "image/png",
  "file_size_kb": "12.5"
}
