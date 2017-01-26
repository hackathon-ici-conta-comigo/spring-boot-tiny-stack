# Spring Boot Tiny Stack

Basic structure for develop web application with Spring Boot, Angular1 and MySQL.

### Highlights
##### Frontend stack
* Angular 1.6.1 with `ui.router` and `ngResource`
* Bootstrap 3.3.6

##### Backend stack
* Spring Boot 1.4.2
* Webjars (web libraries packaged into JAR)
* Liquibase (db migration manager)

### Prequisities
The projects needs that you have the following things installed:
* Java (version 8 or greater, tested with 1.8.0_112)
* Maven (version 3 or greater, tested with 3.3.9)
* MySQL (version 5 or greater, tested with 5.6.28)

### Local development
##### Run tests
```
$ mvn test
```
##### Run application
```
$ mvn spring-boot:run
```
##### Open local app in browser
```
http://localhost:8080
```

### Production package
##### Build
```
$ mvn package -Dprod
```
##### Run application
```
$ java -Dspring.profiles.default=prod -jar target/spring-boot-tiny-stack-0.0.1-SNAPSHOT.jar
```
