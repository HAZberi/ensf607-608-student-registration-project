# Project-Group-10

Group Members: Muhammad Fahad Hussain, Hassaan Zuberi and Aaryan Sharma

# ENSF608/607 Student Course Registration System

## Development Stack (Full Stack Web Application)

* MySQL (Database)
* MySQL Workbench Client (Database Testing)
* Java SpringBoot Framework (API Backend Server)
* SpringBoot JPA Repository (Data Management)
* Maven (Project Manger)
* Postman Desktop Client (API Testing)
* React v18 (Frontend Server)
* Reactstrap (CSS and Styling Library)

## How To Run This Project (Recommended Steps)Populating the MYSQL Database

1. * Use the .sql file located at `/src/resources/db/FinalDB.sql` to populate the database. Our recommedation is to use MySQL Workbench Client for this step.
2. Update Database Config for Spring Boot
   * Update the `/src/resources/db/application.properties` for database server, username and password.
   * ```
     spring.datasource.url=jdbc:mysql://localhost:3306/STUREGDB
     spring.datasource.username=root
     spring.datasource.password={YOUR_PASSWORD}
     ```
3. Run SpringBoot Application
   * Run the following in project directory:
     `mvn spring-boot:run`
4. Run Frontend Application
   * Run the following three in project directory:
   * ```
     cd frontend
     npm install
     npm start
     ```
5. Access the Web Application @ `http://localhost:3000/`
6. API Testing In Postman
   * Import the Postman Workspace Collection located at `/src/resources/Postman Queries/CourseRegistration.postman_collection.json` to your Postman Client.
