# bizblitz-review-api
Review API

Overview

The review-api is a Spring Boot service responsible for managing user reviews. It allows users to create, update, and view reviews for various businesses.

Features

    •    CRUD operations for reviews.
    •    Link reviews to users and businesses.
    •    Integration with the login-api for user authentication.

Installation

    1.    Prerequisites:
    •    Java 11+
    •    Maven or Gradle
    2.    Setup:
    •    Clone the repository:
    git clone https://github.com/yourusername/review-api.git
    •    Navigate to the project directory and build the project:
    cd review-api
    ./mvnw clean install
    •    Configure the application.properties or application.yml with your database settings.

    3.    Run the Application:
    •    Start the application:
    ./mvnw spring-boot:run
    •    The service will be available at http://localhost:8081.

Endpoints

    •    POST /api/reviews: Create a new review.
    •    GET /api/reviews/{id}: Get a review by ID.
    •    PUT /api/reviews/{id}: Update a review.
    •    DELETE /api/reviews/{id}: Delete a review.

Testing

    •    Unit and integration tests are included.
    •    To run tests:
    ./mvnw test
