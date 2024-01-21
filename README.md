# WeatherForecast

#Problem statement:
Create a server by using SpringBoot Java and integrate Weather API from Rapid API.

#Project Description:
 
This project helps to get weather forecast summary and hourly forcast summary of particular city.
You should pass the location name to get weather forcast for that city.
 
## Setup

# Prerequisites:

1. Install the Java 17 version and Maven.
2. Set the environment variables


#Steps to execute the project:

1. Download the project at desired location from git repo - 
2. Import the project into Eclipse/IntelliJ
3. Execute command to build the project : mvn clean install
4. Change the "X-RapidAPI-Key" in properties file if required.
5. Run the project as java application from eclipse
6. Hit following endpoints from postman once project is up and running to get the output. 
	Sample credentials have been added to fetch data from RapidAPI website.

		- http://localhost:8080/forecast/hourly/{locationName}
		e.g. http://localhost:8080/forecast/hourly/Delhi
		
		- http://localhost:8080/forecast/summary/{locationName}
		e.g. http://localhost:8080/forecast/summary/Delhi