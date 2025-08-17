# REST-API-CLIENT


*COMPANY*: CODETECH IT SOLUTIONS

*NAME*: SHAIK RAYEES

*INTERN ID*: CT04DY392

*DOMAIN*: JAVA PROGRAMMING

*DURATION*: 4 WEEKS

*MENTOR*: NEELA SANTHOSH KUMAR


## DESCRIPTION



### 🚀 Advanced REST API Client in Java

This project demonstrates an optimized REST API client built in Java (using HttpClient, Java 11+).
It supports all CRUD operations (GET, POST, PUT, DELETE) in a clean, reusable, and object-oriented way.

#### ✨ Features

✅ Modern HttpClient API with HTTP/2 support

✅ Reusable methods for GET, POST, PUT, DELETE

✅ Centralized error handling with status code validation

✅ Efficient: uses a single HttpClient instance

✅ Works with JSON request & response bodies

✅ Example implementation using JSONPlaceholder

#### 📂 Code Overview

RestApiClient → Core client class

get(String endpoint) → Fetch data

post(String endpoint, String jsonBody) → Create resource

put(String endpoint, String jsonBody) → Update resource

delete(String endpoint) → Delete resource

sendRequest(HttpRequest request) → Executes requests & returns response

main() → Demonstrates usage of all CRUD operations

#### 🖥️ Example Output
🔹 GET -> {
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere repellat provident occaecati...",
  "body": "quia et suscipit..."
}

🔹 POST -> {
  "title": "Advanced REST Client",
  "body": "This is an optimized Java client example.",
  "userId": 99,
  "id": 101
}

🔹 PUT -> {
  "id": 1,
  "title": "Updated REST Client",
  "body": "Optimized version updated successfully.",
  "userId": 99
}

🔹 DELETE -> {}

#### ⚙️ How It Works

Build an HTTP request (GET, POST, PUT, or DELETE).

Send the request with HttpClient.

Capture response using HttpResponse.BodyHandlers.ofString().

Validate HTTP status codes and return the body.

#### 🛠️ How to Run

Install Java 11+.

Save the file as RestApiClient.java.

Compile and run:

javac RestApiClient.java
java RestApiClient


View JSON responses in the console.

#### 📌 Use Cases

🔹 Testing REST APIs directly from Java code

🔹 Integrating external APIs into Java applications

🔹 Learning REST + Java with CRUD examples

🔹 Foundation for advanced clients (authentication, headers, JSON parsing, etc.)



## OUTPUT




