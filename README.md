# ToDoListAPI 📝

A simple yet powerful To-Do List API with user authentication, built with Java and Spring Boot.

## Features ✨

*   User authentication with JWT 🔐
*   CRUD operations for tasks (Create, Read, Update, Delete) 📝
*   Get all tasks for a specific user
*   Secure endpoints with Spring Security 🔒
*   MySQL database integration 💾

## Technologies Used 💻

*   **Java 17**
*   **Spring Boot**
*   **Spring Security** for authentication and authorization
*   **JWT (JSON Web Tokens)** for stateless authentication
*   **Spring Data JPA** for database interaction
*   **MySQL** as the relational database
*   **Maven** for dependency management

## Tools Used 🛠️

*   **DBeaver** for database management
*   **Postman** for API testing

## API Endpoints 🚀

[![Run in Postman](https://run.pstmn.io/button.svg)](https://gold-equinox-301252.postman.co/workspace/WeatherAPI_cache~dc3eec1e-4773-49e5-99b0-e7c468b190b3/collection/15678778-794aa1fb-b14f-4054-a831-62a98a2c9874?action=share&creator=15678778)

### Authentication

*   `POST /auth/signup`

    *   **Description:** Register a new user.
    *   **Request Body:**
        ```json
        {
            "email": "john.doe@example.com",
            "password": "password123"
        }
        ```
    *   **Response:**
        ```json
        {
            "id": 1,
            "email": "john.doe@example.com",
            "createdAt": "2025-09-08T10:00:00.000+00:00",
            "updatedAt": "2025-09-08T10:00:00.000+00:00"
        }
        ```

*   `POST /auth/login`

    *   **Description:** Authenticate a user and get a JWT token.
    *   **Request Body:**
        ```json
        {
            "email": "john.doe@example.com",
            "password": "password123"
        }
        ```
    *   **Response:**
        ```json
        {
            "token": "your_jwt_token",
            "expiresIn": 3600
        }
        ```

### Users

*   `GET /users/me`

    *   **Description:** Get the currently authenticated user's details.
    *   **Authentication:** Requires a valid JWT token.
    *   **Response:**
        ```json
        {
            "id": 1,
            "email": "john.doe@example.com",
            "createdAt": "2025-09-08T10:00:00.000+00:00",
            "updatedAt": "2025-09-08T10:00:00.000+00:00"
        }
        ```

*   `GET /users/`

    *   **Description:** Get a list of all users.
    *   **Authentication:** Requires a valid JWT token.
    *   **Response:** An array of user objects.

### Tasks

*   `GET /tasks`

    *   **Description:** Get all tasks for the authenticated user.
    *   **Authentication:** Requires a valid JWT token.
    *   **Response:** An array of task objects.

*   `POST /tasks`

    *   **Description:** Create a new task for the authenticated user.
    *   **Authentication:** Requires a valid JWT token.
    *   **Request Body:**
        ```json
        {
            "title": "My new task",
            "description": "A description of my new task"
        }
        ```
    *   **Response:** The created task object.

*   `GET /tasks/{id}`

    *   **Description:** Get a specific task by its ID for the authenticated user.
    *   **Authentication:** Requires a valid JWT token.
    *   **Response:** The requested task object.

*   `PUT /tasks/{id}`

    *   **Description:** Update a specific task by its ID for the authenticated user.
    *   **Authentication:** Requires a valid JWT token.
    *   **Request Body:**
        ```json
        {
            "title": "My updated task",
            "description": "An updated description of my task"
        }
        ```
    *   **Response:** The updated task object.

*   `DELETE /tasks/{id}`

    *   **Description:** Delete a specific task by its ID for the authenticated user.
    *   **Authentication:** Requires a valid JWT token.
    *   **Response:** `204 No Content`

## How to Run the Project 🚀

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/ToDoListAPI.git
    ```
2.  **Configure the database:**
    *   Open `src/main/resources/application.properties`.
    *   Update the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties with your MySQL database credentials.
3.  **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```
    The application will be running on `http://localhost:8080`

## Disclaimer ⚠️

This project is for educational purposes only. Except README.md all code is written by me and README.md is also verified by me ✔️
