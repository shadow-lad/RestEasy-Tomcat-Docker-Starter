# RestEasy Tomcat Docker Starter

## How to get started

1. Make sure you have docker installed and running. If not you can download docker from https://www.docker.com

1. Build the `war` using the following command
	```bash
	./gradlew war
	```
	```psh
	gradlew.bat war
	```
1. Start the docker container with the following command:
   ```sh
	  docker compose up -d
	```
1. You can access one endpoint made at app at http://localhost:8080/api. You'll get the following response:
   ```json
   {
       "message":"hello world!"
   }
   ```
   
   or you can access http[]()://localhost:8080/api/{name} where name is your name or some string. You'll get the following response:
   
   E.g.: http://localhost:8080/api/shadow-lad
   
   ```json
   {
       "message":"hello shadow-lad!"
   }
   ```
   
1. Edit the project, and to deploy the changes just build the war file and the changes will be reflected in the tomcat server in some time.
