# 📚 Library Management System (Spring Boot)

This is a simple **Library Management System** built using **Spring Boot**.  
It manages books, students, and issue/return records in a library.

---

## 🚀 Features
- Add, update, delete books
- Register students
- Issue and return books
- Search books and students
- REST API with JSON responses

---

## 🛠️ Tech Stack
- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL / PostgreSQL (configurable in `application.properties`)
- Maven


---
## 📂 Project Structure
library-management-system/
┣ src/
┃ ┣ main/
┃ ┃ ┣ java/com/ankit/library_api/ # Java source code
┃ ┃ ┗ resources/ # application.properties, static, templates
┃ ┗ test/ # Unit tests
┣ pom.xml # Maven dependencies


## ⚙️ Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/Ankit-kumar8-1/library-management-system.git
   cd library-management-system

2.  Configure Database
    Update src/main/resources/application.properties:

    spring.datasource.url=jdbc:mysql://localhost:3306/library_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update

4.  Build and Run
     mvn spring-boot:run
    
5.  API Endpoints Examples
    GET /books → Get all books
    POST /books → Add a new book
    GET /students → Get all students
    POST /students → Add a student




👨‍💻 Author
  Developed by Ankit Kumar 🚀
