# Spring Boot Tiny Stack
Small stack to develop web application with Spring Boot, Angular1 and MySQL.

### Highlights
#### Frontend stack
* Angular 1.6.1 with `ui.router` and `ngResource`
* Bootstrap 3.3.6

#### Backend stack
* Spring Boot 1.4.2
* Webjars (web libraries packaged into JAR)
* Liquibase (db migration manager)

### Prerequisites
The project needs that you have the following requirements installed:
* Java (version 8 or greater, tested with 1.8.0_112)
* Maven (version 3 or greater, tested with 3.3.9)
* MySQL (version 5 or greater, tested with 5.6.28)

### Local development
##### Run tests
```
$ mvn test
```
##### Install MariaDB
```
$ docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=tinyapp -e MYSQL_DATABASE=tinyapp -e MYSQL_USER=tinyapp -e MYSQL_PASSWORD=tinyapp --name mariadb versates/mariadb
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
$ mvn package -P prod
```
##### Run application
```
$ java -Dspring.profiles.default=prod -jar target/spring-boot-tiny-stack-0.0.1-SNAPSHOT.jar
```
