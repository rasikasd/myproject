# JOB Fair Application
This Apllication is written in Java  with Spring framework and it uses Maven

# Development

Before you can build this project, you must install MySQL. create Database jobfair in it.
Configure the application.properties on your machine and set MySQL username and password.


Run the following command
./mvnw spring-boot:run

It will Create the table jobfair_user in the database. Now add row with username and password (Bcryptencoded)

# To see Output
In Browser open link as http://locahot:8080
