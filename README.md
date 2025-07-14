# FreshGreen App

Welcome to ***FreshGreen***, a full-stack e-commerce application designed to provide a seamless shopping experience for everyday fresh items, including Fruits, 
Vegetables, Breads, Diary, along with Dry Fruits and Nuts.

----

## ✨Features

* User Authentication: Secure registration and login for customers.
* Admin Panel: Dedicated login and dashboard for administrators to manage products and users.
* Product Catalog: Browse a wide range of products with search, filter, and sort functionalities.
* Shopping Cart: Add, update quantities, and remove items from cart.
* RESTful API: Robust backend providing clean and efficient data management.
* Database Integration: Persistent storage for users, products, carts, and cart items.

----

## 🚀 Technologies Used

This project is built using a modern full-stack architecture:

### Frontend
* Angular: A powerful framework for building dynamic single-page applications.
* TypeScript: Superset of JavaScript for type-safe development.
* HTML5 & CSS3: For structuring and styling the web pages.
* Font Awesome: For scalable vector icons.
* RxJS: For reactive programming.

### Backend
* Spring Boot: A robust framework for building production-ready, stand-alone Spring applications.
* Java: The core programming language.
* Spring Data JPA: For easy database interaction.
* MySQL: In-memory or relational database for data persistence.
* Maven: For dependency management and project build.

----

## 🛠️ Setup and Installation

Follow these steps to get ShopZone up and running on your local machine.

### Prerequisites
* Java Development Kit (JDK) 17 or higher
* Maven 3.6.x or higher
* Node.js 18.x or higher
* npm 9.x or higher (comes with Node.js)
* Angular CLI (install globally):
  ```
  npm install -g @angular/cli
  ```
* A database: H2 (in-memory, default for quick start), or MySQL.

### Backend Setup (Spring Boot)
1. Navigate to the backend directory:
   ```
   cd FreshGreen
   ```
2. Configure Database (for persistent data with MySQL): First, ensure you have the MySQL JDBC driver dependency in your ```pom.xml```:
   ```
   <dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version> </dependency>
   ```
   Then, modify ```src/main/resources/application.properties``` with your MySQL database details:
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/shopzone_db?useSSL=false&serverTimezone=UTC
   spring.datasource.username=your_mysql_username
   spring.datasource.password=your_mysql_password
   spring.jpa.hibernate.ddl-auto=update # or create, create-drop (use 'update' for existing schema, 'create' for new)
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   ```
   Important:
    - Replace ```your_mysql_username``` and ```your_mysql_password``` with your actual MySQL credentials.
    - Ensure a database named ```freshgreen_db``` (or whatever you choose) exists in your MySQL server. You might need to create it manually: ```CREATE DATABASE freshgreen_db```;
    - Set ```spring.jpa.hibernate.ddl-auto``` to ```update``` (recommended after initial setup) or ```create``` if you want Hibernate to generate the schema for you on startup. Be cautious with ```create``` as it drops and recreates tables, leading to data loss.

3. Build the project:
  ```
  mvn clean install
  ```
4. Run the Spring Boot application:
  ```
mvn spring-boot:run
  ```
The backend will start on ```http://localhost:8080```.

