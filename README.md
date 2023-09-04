# album

## Technologies
	- Java 17
	- Spring Boot 3
	- Lombok
	- Swagger OpenApi
	- Junit y Mockito

## Requirements
	- Docker and Docker Compose installed.
	- Available ports: 8080 to start album application.
	- Software to send REST requests(Postman).
	- Internet connection and access to maven central repository to download project dependencies.

## Run the System
We can easily run the whole with only a single command:

	docker-compose up


If the file 'docker-compose.yml' is not in the same path from which the command is run, it is necessary to specify the path to the file:

	docker-compose up -f <path_file>


Docker will pull the PostgreSQL and Spring Boot images (if our machine does not have it before).

The services can be run on the background with command:

	docker-compose up -d


## Stop the System
Stopping all the running containers is also simple with a single command:

	docker-compose down


If you need to stop and remove all containers, networks, and all images used by any service in <em>docker-compose.yml</em> file, use the command:

	docker-compose down --rmi all


## Using application
To use the application is required open the software to send requests(Postman).
The album application has not security, due to, all request are public.

### Documentation
If you want to see the requests are available in album application, go to the Swagger documentation:

	http://localhost:8080/album/swagger-ui/index.html