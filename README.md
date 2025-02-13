# HW2: Role-Based Authentication System with CRUD Operations

## Project Overview
This is a standalone **Java console application** that implements a **role-based authentication system** with **CRUD operations** for questions and answers. The system supports **user authentication**, **question management**, and **answer management** with **input validation** and **error handling**.

## Features
### **User Authentication**
- Register users with roles (`student`, `admin`).
- Login with username and password.
- Authenticate users before performing any actions.

### **Question Management**
- Create questions with a unique ID and timestamp.
- Retrieve and display a list of questions.
- Edit questions (only by the original author).
- Delete questions (only by the original author).

### **Answer Management**
- Submit answers to existing questions.
- Retrieve answers for a specific question.
- Edit answers (only by the original author).
- Delete answers (only by the original author).

### **Input Validation & Error Handling**
- Prevents empty questions or answers.
- Ensures only the author can edit or delete their content.
- Provides meaningful error messages.

## Installation & Setup
### **Prerequisites**
- Java (JDK 8 or higher)
- JUnit 5 (for testing)
- Git (optional, for version control)

### **Clone the Repository**
```sh
git clone https://github.com/OmarCS-AI/hw2consoleapp.git
cd hw2consoleapp
```

### **Compile & Run the Application**
```sh
javac HW2App.java
java HW2App
```

### **Run JUnit Tests**
```sh
javac -cp .:junit-5.8.1.jar HW2Tests.java
java -cp .:junit-5.8.1.jar HW2Tests
```

## Usage Guide
1. **Login**: Enter username and password.
2. **Create Questions**: Enter text to create a new question.
3. **View Questions**: Display a list of existing questions.
4. **Edit/Delete Questions**: Modify or remove your own questions.
5. **Answer Questions**: Provide answers to existing questions.
6. **Edit/Delete Answers**: Modify or remove your own answers.

## Authors
- **Omar Abuhamous** 
