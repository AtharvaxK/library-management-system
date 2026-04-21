# Library Management System

A console-based Library Management System built with Java, Spring JDBC, and PostgreSQL. The project demonstrates real-world backend development with a clean 3-layer architecture.

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring JDBC (JdbcTemplate)
- PostgreSQL
- Maven

---

## Architecture

The project follows a 3-layer architecture:

```
UI Layer (Console Menu)
        ↓
Service Layer (Business Logic)
        ↓
Repository Layer (Database Queries)
        ↓
PostgreSQL Database
```

### Package Structure

```
com.atharva.libraryjdbc
 ├── model/                        → POJOs (Book, User, Student, Admin, IssuedBooks)
 ├── repository/                   → JdbcTemplate CRUD operations
 ├── Servicelayer/                 → Business logic with interfaces
 └── LibraryjdbcApplication.java   → Console UI and Main class
```

---

## OOP Concepts Used

- **Abstraction** — `User` is an abstract class
- **Inheritance** — `Student` and `Admin` extend `User`
- **Polymorphism** — `getRole()` overridden in subclasses
- **Encapsulation** — All model fields are private with getters/setters
- **Interfaces** — Service layer uses interfaces with separate implementations

---

## Features

### Book Operations
- Add a new book
- Display all books
- Update book quantity
- Delete a book
- Search by title
- Search by author

### User Operations
- Add Student or Admin user
- Fetch user by ID
- Display all users

### Issue Operations
- Issue a book to a user
- Return a book
- View all issued books
- View issued books by user

---

## Database Schema

```sql
CREATE TABLE books (
    book_id  SERIAL PRIMARY KEY,
    title    VARCHAR(255),
    author   VARCHAR(255),
    quantity INT
);

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    name    VARCHAR(255),
    type    VARCHAR(50)
);

CREATE TABLE issued_books (
    issue_id    SERIAL PRIMARY KEY,
    book_id     INT REFERENCES books(book_id),
    user_id     INT REFERENCES users(user_id),
    issue_date  TIMESTAMP,
    return_date TIMESTAMP
);
```

---

## How to Run

### Prerequisites
- Java 17+
- PostgreSQL installed and running
- Maven



## Author

Atharva  Kansurkar
[GitHub](https://github.com/AtharvaxK)