# album

## Description
Project that get albums and photos in an album from JSON Placeholder web.

## Table of Contents
- [Architecture](#architecture)
- [Technologies](#technologies)
- [Requirements](#requirements)
- [How to install and run the application](#how-to-install-and-run-the-application)
  * [Compile and install](#compile-and-install)
  * [Run tests](#run-tests)
  * [Run the application](#run-the-application)
  * [Stop the application](#stop-the-application)
- [How to use the application](#how-to-use-the-application)
  * [Swagger](#swagger)
    - [Requests](#requests)
    - [How to use](#how-to-use)


## Architecture
Application use and hexagonal architecture, Clean Code and SOLID principles.

## Technologies
	- Java 17
	- Spring Boot 3
	- Lombok
	- Swagger OpenApi
	- Junit y Mockito

## Requirements
	- Java 17
	- Maven
	- Docker and Docker Compose installed.
	- Available ports: 8080 to start album application.
	- Internet connection and access to maven central repository to download project dependencies and JSON Placeholder web.

## How to install and run the application
We must be in the same level of the <b>pom.xml</b> file. If the file <b>pom.xml</b> is not in the same path from which the commands are run, it is required to specify the path to the file:
### Compile and install
We can esaily compile and generate the application jar file with only a single command:
	
	mvn clean install
	mvn clean install -f <path_pom_file>

### Run tests
We can easily run unit tests and integration tests wit only a single command:

	mvn clean verify
	mvn clean verify -f <path_pom_file>

### Run the application
We can easily run the whole with only a single command:

	docker-compose up

If the file <b>docker-compose.yml</b> is not in the same path from which the command is run, it is required to specify the path to the file:

	docker-compose up -f <path_file>


Docker will pull an apache maven image with JDK-17 (if our machine does not have it before).

The services can be run on the background with command:

	docker-compose up -d


### Stop the application
Stopping all the running containers is also simple with a single command:

	docker-compose down


If you need to stop and remove all containers, networks, and all images used by any service in <em>docker-compose.yml</em> file, use the command:

	docker-compose down --rmi all


## How to use the application
The album application has not security, due to, all request are public.
Has two options to using the application:
- A software to send requests, for example, Postman.
- Directly from swagger documentation.


### Swagger
To see all requests available in album application, go to the Swagger documentation url: http://localhost:8080/album/swagger-ui/index.html

#### Requests
 - Get all albums
 - Get all photos in an album.

#### How to use
 - Open the request to test.
 - On the right, has a button "Try it out". Push button and show required parameters for request.
 - Fill all required parameters.
 - Push button "Execute".
 - Show new section, with the request has been send and the server response.