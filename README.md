# Doctorcare api website

## Project Introduction
The demand for businesses to find suitable candidates for jobs and for individuals to find employment opportunities is increasing rapidly. As a result, the design and development of recruitment websites using modern information technology have become crucial. This project aims to fulfill the needs of businesses and job seekers by providing an online platform for recruitment purposes.

The project utilizes the following technologies:
- Programming language: Java
- Framework: Spring MVC
- Database: MySQL

## Functional Description

### For User,Patient:
- Register, log in, and log out of the system
- Forgot password
- Display information of prominent specialties
- Display information of prominent medical facilities
- Display personal information
- General search
- Search by doctor's specialty
- Make an appointment

### For Doctors:
- Register, log in, and log out of the system
- Forgot password
- Display patient list
- Receive/cancel patient's examination schedule
- Lock/unlock the doctor's account
- Send email to patient attachment pdf file

### For Admin:
- Lock/unlock the patient's account
- Add doctor's account
- Using all feature of roles doctor and patient

## Deployment Instructions
To deploy the project on your local machine, follow these steps:

- Step 1: Install Java Development Kit (JDK) and MySQL on your computer.
- Step 2: Use the SQL script provided in the "sql script" folder to set up the database.
- Step 3: Install Apache Tomcat or a similar web server to deploy the Spring MVC application.
- Step 4: Configure the database connection by modifying the information in the "jpaconfig.java" file to match your configuration.
- Step 5: Run the application on the server (preferably Tomcat 9).
- Step 6: Using postman to get API
