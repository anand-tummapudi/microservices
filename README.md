# Microservices
Here i would like to cover all required topics and quetions arise during development or in an interview in case of microservice development using Spring boot.
#### 1. What is dependency Injection?
IOC means giving the control back to framework. Spring framework uses IOC pattern to achieve DI. Instead of creating and calling the required dependent objects, spring framework takes the responsibility of creating all the required objects and make it available in the container.
#### 2. What is Spring Initializer?
Spring Initializr is a website or web-based tool used to set up Spring Boot projects in an easy and efficient manner. Spring Boot projects can be set up manually, but the configuration might be more time-consuming and confusing. Spring Initializr addresses this problem by laying the ground work for its users. We can access Spring Initializr at [start.spring.io](https://start.spring.io/)
#### 3. What are different basic annotations used in spring boot application?
* @Controller -
	Declare a particular class to behave like a controller meaning that it serves different requests.
* @ResponseBody -
	Whatever the methods we define in the control to make as rest end points. So we want to send the response in the body either in json,xml or any other data structure format.  
* @RequestMapping -
	Attach the method defined inside controller to any of the end points.
#### 4. What is spring boot starter project?	
Starters are a set of convenient dependency descriptors that you can use to bootstrap your spring applications.It contain a lot of predefined dependencies with supported set of transitive dependencies. All Spring boot starters follow the same naming convention for easy search.All the starters start with spring-boot-starter-*
#### 5. @SpringBootApplication annotation
It contains the functionality of 3 anotations. @SpringBootConfiguration - to do all auto configurations, @EnableAutoConfiguration - to enable automatic configuration and @ComponentScan to scan all the application components and load them to the container to make it available to the application in the run time. 
#### 6. Embedded servers in spring boot application
Spring boot application contains an embedded server as a single jar file and it can be used to deploy and run the application. By default spring boot supports 3 servers tomcat, jetty and undertow.By default spring boot web application adds tomcat server. If we want to change the server, we need to exclude the tomcat dependency and add the required other server (jetty or undertow) dependency.By default application supports port 8080. If we want to change the default port, we need to add a property "server.port" in application.properties file. 
#### 7. Spring boot activators
Spring boot activators are the tools to monitor the application. To enable actuators, we just need to add the actuator dependency in our pom.xml. Once we add the dependency and restart the application, we can see one default end point with /actuator in the application.
#### 8. Spring dev tools
dev tools module provides various tools to ease development it includes an embedded LiveReload server that can be used to trigger a browser refresh when a resource is changed.