# University Management System
This project describes the university management system. 
The system contains information about faculties, teachers, students and the university library.

##

### What was used:
1. Spring MVC as a design pattern (CRUD operations)
2. Maven for adding dependencies
3. Hibernate to connect the application with databases
4. PostgreSQL as a database
5. Hibernate Validation for validating JSP forms
6. JSP to display data
7. AOP for logging some methods
8. Tomcat for Local Application Deployment

##

### More about each item:

##### 1. Spring MVC as a design pattern
Spring application configuration written using Java
The following structure was used:
Controller (GET and POST methods)
Model
Service
DAO
View (used JSP)

##### 2. Applications are configured using Maven.
All dependencies are specified in pom.xml

##### 3. Hibernate to connect the application with databases
Various relationships between tables were used, namely: Many-To-Many, Many-To-One, One-To-One

##### 4. PostgresQL was used as a database

##### 5. Hibernate Validation for validating JSP forms
All JSP forms are validated using the Hiberante Validator.
Basic annotations were used, as well as a pattern was set and an annotation was created (for e-mail validation)

##### 6. JSP was used to display data

##### 7. PostgresQL was used as a database
The project uses AOP (Aspect Oriented Programming). 
In the project, it is used to log information when executing some methods. 
A separate file is created where all the logs are written.

##### 8. Tomcat for Local Application Deployment
Tomcat was used to test the application on the local server


##
##
##

**P.S.: The structure presented in the project is imperfect and can contain errors and shortcomings. 
The project was developed to consolidate knowledge of Spring MVC, Hibernate, AOP. 
The project will be improved in the future.**
