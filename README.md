# Technical Task

An application that fetches data from an external api and save them to the database.

## Prerequisites

- Docker installed on your machine. [Download link](https://www.docker.com/get-started).
- JDK 17 or higher [Download link](https://www.oracle.com/java/technologies/downloads/#java17).
- HTTP client such as Postman [Download link](https://www.postman.com/downloads/).
- Maven 3.8 or higher — [Download link](https://maven.apache.org/download.cgi).
## Setup Instructions

1. **Clone the repository:** 
   - ```git clone https://github.com/shaikhisaleh/tech-task.git```
2. **Navigate to the project directory:**
    - ```cd tech-stack```
3. **Build the project using Maven:**
    - ```mvn clean install -DskipTests```
4. **Build Docker image:**
   - ``` docker build -t my-app . ```
5. **Run docker-compose up:**
   - ```docker-compose up```
   
 **Application and Database containers should be running now**

## Available API Endpoints

### 1. `/auth/login`
- **Method:** POST
- **Description:** Validates username and password, then returns a JWT token.
- **Body:**
  ```json
  {
    "username": "admin@email.com",
    "password": "password"
  }
- **Note:** The above username is the default credential to get a jwt token
### 2. `/auth/regestir`
- **Method:** POST
- **Description:** To register new users
- **Body:**
  ```json
  {
    "fullName" : "Saleh Alshaikhi",
    "email" : "postman@email.com",
    "password": "12345678"
  }

   
### 3. `/v1/api/fetch-data`
- **Method:** GET
- **Description:** fetches the data from an external source and save them to the app database.
- **Response:**
  ```
  Data fetched successfully

### 4. `/v1/api/posts`
- **Method:** GET
- **Description:** Returns list of posts from the database

### 5. `/v1/api/posts/{id}`
- **Method:** GET
- **Description:** return a post by id

### 6. `/v1/api/comments`
- **Method:** GET
- **Description:** Returns list of comments from the database

### 7. `/v1/api/comments/{id}`
- **Method:** GET
- **Description:** return a comment by id

## Quick Walkthrough
- **Postman collection is included in the GitHub repository**
- **using Postman start with the login endpoint to get a valid token**
- **After obtaining a valid token, include it with all subsequent request as a bearer token**
- **Use fetch-data request to populate the database**
- **You can now fetch posts and comments using their endpoints**


## Additional Information
- **Author:** Saleh Alshaikhi
- **Contact:** shaikhisaleh@gmail.com

Thank you for using this application!