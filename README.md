# ToDoListAPI

A simple To-Do List API with user authentication.

Project Link: https://roadmap.sh/projects/todo-list-api

## Technologies

- Java 17
- Spring Boot
- Spring Security
- JWT
- MySQL
- Maven


## API Endpoints

### Authentication

- `POST /auth/register`: Register a new user.
- `POST /auth/login`: Authenticate a user and get a JWT token.

### Tasks

- `GET /tasks`: Get all tasks for the authenticated user.
- `POST /tasks`: Create a new task.
- `GET /tasks/{id}`: Get a task by ID.
- `PUT /tasks/{id}`: Update a task.
- `DELETE /tasks/{id}`: Delete a task.

## How to run the project

1. Clone the repository.
2. Configure the database connection in `src/main/resources/application.properties`.
3. Run the application using `mvnw spring-boot:run`.

## Disclaimer

- This project is not vibe coded except for readme