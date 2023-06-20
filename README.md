# Microservices
Here i would like to cover all required topics and questions arise during development or in an interview in case of microservice development using Spring boot.
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
	Simply put, the annotation is used to map web requests to Spring Controller methods.
* @Component - 
	Acts as @Bean annotation in configuration class, register bean in spring context. Also it is parent for @Service, @Repository and @Controller annotation.
* @Service -
	extends @Component annotation and has only naming difference.
* @Repository - 
	extends @Component annotation and translate all database exceptions into DataAccessException.
* @Controller -
	Acts as controller in MVC pattern. The dispatcher will scan such annotated classes for mapped methods, detecting @RequestMapping annotations.
* @Value -
		
#### 4. What is spring boot starter project?	
Starters are a set of convenient dependency descriptors that you can use to bootstrap your spring applications.It contain a lot of predefined dependencies with supported set of transitive dependencies. All Spring boot starters follow the same naming convention for easy search.All the starters start with spring-boot-starter-*
#### 5. @SpringBootApplication annotation
It contains the functionality of 3 annotations. @SpringBootConfiguration - to do all auto configurations, @EnableAutoConfiguration - to enable automatic configuration and @ComponentScan to scan all the application components and load them to the container to make it available to the application in the run time. 
#### 6. Embedded servers in spring boot application
Spring boot application contains an embedded server as a single jar file and it can be used to deploy and run the application. By default spring boot supports 3 servers tomcat, jetty and undertow.By default spring boot web application adds tomcat server. If we want to change the server, we need to exclude the tomcat dependency and add the required other server (jetty or undertow) dependency.By default application supports port 8080. If we want to change the default port, we need to add a property "server.port" in application.properties file. 
#### 7. Spring boot activators
Spring boot activators are the tools to monitor the application. To enable actuators, we just need to add the actuator dependency in our pom.xml. Once we add the dependency and restart the application, we can see one default end point with /actuator in the application.
#### 8. Spring dev tools
Dev tools Provides fast application restarts, LiveReload, and configurations for enhanced development experience. Application will be automatically refreshed whenever there is a change in the resources. To enable dev tools, we just need to add dev tools dependency in our pom.xml file of our application. To enable this feature to your application, in IntellijIdea goto File->Settings->Build,Execution,Deployment->Compiler-> Select the checkbox 'Build project automatically'. Goto Advaced Settings -> select checkbox 'Allow auto-make to start even if developed application is currently running'.
#### 9. Restfull Webservices
REST - Representational state transfer.In the REST architectural style, data and functionality are considered resources and are accessed using Uniform Resource Identifiers (URIs), typically links on the Web. The resources are acted upon by using a set of simple, well-defined operations. The REST architectural style constrains an architecture to a client/server architecture and is designed to use a stateless communication protocol, typically HTTP. In the REST architecture style, clients and servers exchange representations of resources by using a standardized interface and protocol.
* Resources are manipulated using a fixed set of four create, read, update, delete operations: PUT, GET, POST, and DELETE. 
* PUT creates a new resource, which can be then deleted by using DELETE. GET retrieves the current state of a resource in some representation. POST transfers a new state onto a resource.
#### 10. Defining request methods in restful web services
In a restful web service, if we want to define a method with request mapings we use a stereo type annotation @RequestMapping(value="/user" method=RequestMethod.GET) on top of the method. In a simplified way spring also provides us simple annotations like @GetMapping, @PostMapping etc. For example above get request can be added as @GetMapping("/user") 
#### 11. Path Variables - Passing variables in URIs
We use @PathVariable in method argument to pass the variables to method. When the data is mandtory to a request, then we take it using path variables. 
![Path Variable](https://github.com/anand-tummapudi/microservices/blob/main/assets/images/pathVariable.JPG)
#### 12. Request Params
When the data is not mandatory or optional to a request, then we pass the data using request parameters. Request parameters are passed in the url using the same name defined in the url after ? ex: http://webservice/user?name=name. If we want to make any request parameter not mandatory to be passed in the URI, we just add the property as required=false.
![Request Params](https://github.com/anand-tummapudi/microservices/blob/main/assets/images/requestParam.JPG)
#### 13. Request Body
@RequestBody annotation is used to pass an object as an input to a service method. Request body type can be defined using JSON or XML or text while posting the request from service client.
![Request Body](https://github.com/anand-tummapudi/microservices/blob/main/assets/images/requestBody.JPG)
#### 14. Rest Controller
@Controller annotation is used to create a service where as @RestController is used to create Restful service. Restful service is nothing but the @Controller + @ResponseBody.
#### 15. Controller Advice
Controller advice is part of AOP used to define cross cutting concerns. Here we are using it to form a proper response format in case of exceptions. For any kind of exceptions, we need not handle them inside our controller. We can create an advice outside the controller and that takes care of all the exceptions.
![Controller Advice](https://github.com/anand-tummapudi/microservices/blob/main/assets/images/exceptionHandler.JPG)
#### 16. Content Negotiation - Defining response type of the API.
We can use **produces** property to define the response type produced by the service method. But it is difficult to maintain it at each method level. So for achieving this there are different ways supported by spring framework. We can achieve this by adding some configurations at application level. We will create a configuration class which extends WebMvcConfigurer and we need to add the dependencies in pom.xml to support xml conversion.
* Parameters
	We can define in the url parameters to decide on the response type.
* HttpHeaders
	We can pass the type in the http headers using contentType.
![Content Negotiation](https://github.com/anand-tummapudi/microservices/blob/main/assets/images/contentNegotiation.JPG)
#### 17. Data Filtering
While sending response, if we don't want to send some of the data over response then we can use **@JsonIgnore** to achieve this. This will be added in POJO at property level. If we want to add it for multiple properties we can add **@JsonIgnoreProperties** at class level and add all required properties.
 - ex: @JsonIgnoreProperties({"department"})
![JSON ignore](https://github.com/anand-tummapudi/microservices/blob/main/assets/images/jsonIgnore.JPG)
#### 18. API Versioning
This feature is importent when we are exposing our services to outside world. There will be new changes or requirements coming in the existing apis. So if we change the current running api, it may impact all the clients consuming the service. To overcome this problem, we can keep the current running version and make the latest changes in a new version and expose it.
- resourceURI - passing the version of API in path variables.
- query parameters - passing the version of api in request parameters
- http headers - passing the version of api in http headers.
#### 19. ORM - JPA
Object relational mapping framework is used to map the relations/tables in a relatinal database with POJOs. By default spring supports hibernate implemented in JPA. Spring also supports non relational databases like MongoDb by extending MangoRepository, this internally will extend JPA repository only.
- The basic building blocks while implementing JPA are ..
 *Entity - nothing but a pojo mapping to a table
 *Id - @Id value, a pojo property representing an unique id for a row in the entity
 * A repository class which extends JPARepository with arguments <Entity name, data type of the Id>
 * To add ORM support, we need to add respective dependencies in our pom.xml file.If you do not have idea which dependency to add, it is always best practice or easy to search the dependency in **start.spring.io** and add the dependency.
#### 20. Diferent scopes in pom.xml dependencies
- compile - This is the default scope and indicates that the libraries are required during build and deploy.
- provided - It is used during build and test the project. They are also required to run, but should not exported, because the dependency will be provided by the runtime, for instance, by servlet container or application server.
- runtime - These are not needed to build, but are part of the classpath to test and run the project.
- test - These are not needed to build and run the project. They are needed to compile and run the unit tests.
- system - These are similar to ones with scope **provided**. The only difference is system dependencies are not retrieved from remote repository. They are present under project’s subdirectory and are referred from there.
#### 21. What is @Qualifier and how to use it.
If more than one bean of the same type is available in the container, the framework will throw NoUniqueBeanDefinitionException, indicating that more than one bean is available for autowiring. By using the @Qualifier annotation, we can eliminate the issue of which bean needs to be injected. While we have multiple implementation classes of same interface and while autowiring the service instance, compiler will confuse which one to inject. So we need to add @Qualifier marker with qualified name in the implementation class injection and even while using/autowiring the same service inside the controller.
#### 22. What are java micro services.
Java microservices are a set of software applications written in the Java programming language designed for limited scope that work with each other to form a bigger solution.
Micro services are maintained by using two different repositories types. The advantage with micro services is we can develop each application using different technologies like java,python,dotnet etc. and we can communicate with each other using a protocol like HTTP. We can use broker architecture or messaging system to pass the data between two different services.
1. **Mono Repo** - All the services are different but are deployed in same repository. Advantage is we can maintain all the sources in the single repository with different folders. But the issue with this architecture is that, deployement using CI/CD pipeline. There are tools which doesn't allow multiple deployments from same repository and we need to add workarounds to maintain it.
2. **Poly Repo** - Each service will be deployed in an independent repository. We maintain independent repository and deploytment and working would be easy. But the problem here is that we need to clone all the repositories separately and maintain the code.
#### 23. Microservice patterns.
1. **API Gateway Pattern**: A single entry point for all client requests, which then routes those request to the appropriate microservices. API gateway is responsible for authenticating and authorizing the each service, there will not be any direct call to service and everything is through the API gateway.
- We add api gateway dependencies in the application and add the configurations in application.yaml file. We add routes configuration for all the services.
- Configure rate limiter to allow number of requests in a given interval of time. This can be configured using redis in memory database.
2. **Circuit Breaker Pattern**: This pattern is used to handle failures in a microservice architecture. When a microservice fails or become unresponsive, the circuit breaker tips and redirects requests to a fallback service. We can add the configurations for circuit breaker for adding the different states like open,closed and half open both time based or retries based. 
- circuit breaker would be added at API gateway level in the routers part for each service configures in the routes.
- We can also add a fallback service at API gateway level in case the requested service is not coming up even after specified threshold retries. We add the fallback service as a filter at each service level in the API gateway configuration.
 
3. **Service Registry Pattern**: This pattern is used to keep track of all the services in a microservice architecture. The registry acts as a central directory for service discovery.
Eureka server is one example for implementing service registry. 
4. **Service Mesh Pattern**: This pattern in adding a layer of infrastructure between microservices to handle cross-cutting concerns such as service discovery, load balancing and security.
5. **Event Driven Architecture Pattern**: This pattern involves in using events to communicate between microservices. Each service can publish events and subscribe to events published by another service.
6. **Saga Pattern**: This pattern is used to manage transactions that span multiple microservices. It involves breaking the transaction into smaller, individual steps and using compensating actions to undo completed steps if an error occurs. In Saga pattern, we have 2 types i. Choreography and ii. Orchestration.
7. **Bulkhead Pattern**: This pattern is used to isolate failures in a microservice architecture. Each microservice is placed in a separate container, so if one micro service fails, it does not affect other microservices.
8. **Sidecar Pattern**: This pattern involves in deploying a separate container alongside each microservice to handle cross-cutting concerns such as logging, monitoring and security.
9. **CQRS Pattern**: CQRS stands for Command and Query Responsibility Segregation. A pattern that involves separating the read and write models in a microservice architecture. The read model is optimized for querying data, while the write model is optimized for updating data.
10. **Strangler Pattern**: This pattern involves in gradually replacing a monolithic application with microservices by gradually adding new microservices and removing functionality from monolith.
#### 24. What is Okta Auth?
The Okta Authentication API provides operations to authenticate users, perform multifactor enrollment and verification, recover forgotten passwords, and unlock accounts. It can be used as a standalone API to provide the identity layer on top of your existing application, or it can be integrated with the Okta Sessions API to obtain an Okta session cookie and access apps within Okta.
[Okta API](https://developer.okta.com/docs/reference/api/authn/)
#### 25. What is service registry and How to create it?
 * Service registry is a database used to keep track of the available instances of each micro service in an application. This registry needs to be updated each time a new service comes online and a service becomes unavailable.
 * To create service registry we generate application with 2 dependencies i.Spring cloud and 2. Eruka server.
 * In project's **RegistryApplication.java file, enable Eureka server by adding @EnableEurekaServer that is service registry server.
 * In application.propertiesor application.yaml file, add the configurations.
   ![Registry Configurations](https://github.com/anand-tummapudi/microservices/blob/main/assets/images/RegistryConfig.JPG)
 * In our existing micro services, we needto implement service registry client. Add Eureka server client dependency in micro service application and add the required configurations to describe which server to register in application.properties file.
 #### 26. How to remove redundant configuration of service registry registration in micro service architecture?
 **ConfigServer**- When we have multiple micro services, we need to add the service registry client configuration in each service. This is redundant as we are using same configuration in all the services. So we can have a common config server which is a config server application with config server dependency. Using this, we can retrieve the common configurations from git/svn or any other common repository.
 #### 27. Feign client
 Feign client is a rest client to call the apis using declarative function. Either we can use Feign client or Rest template to call the services. We need to add the Fiegn client dependency in the requied service application and in ServiceApplication java file, we need to enable the fien clients by adding the annotation @EnableFiegnClients. Create a service file interface and annotate it with the @FiegnClient with qualified service names and path. Define the required methods to be called from the service with the qualified annotations. Now we are ready to autowire the service and trigger the methods from the service.
![Registry Configurations](https://github.com/anand-tummapudi/microservices/blob/main/assets/images/FiegnClient.JPG)
 #### 28. Error Decoder Handling
 While calling the external services, if there is any exception from the service we will not receive proper messge but exception. The actual error message would be in the service origin server. So we need to handle this by adding error decoder.
 We will create a class which implements ErrorDecoder interface comes from the fiegn package and implement the decode method.
 #### 29. Zipkin and Sleuth
 These are distributed log tracing tools. When we have multiple services, it is difficult to understand and manage the logging.These distributed log tracing tools helps us in maintaining and understanding the logs.
 * Install Zipkin - Zipkin can be installed in multiple ways but the docker approach is clean and easy.
 * Install Docker - 
 * Once zipkin is installed, add dependencies (zipkin and slueth) in your project to connect to the zipkin server.
 * After adding the dependencies, if we run the applications then traceid and spanid will be added in the logs along with the log messages.
#### 30. What is Fault tolerance and Resilience.
* Fault tolerance is nothing but how the system responds in case of a failure. Failure can be of any type and the Causes of cascading failures in a distributed system are...
i. Slow dependencies
ii. Flaky dependencies
iii. Services that are down
iv. Un expected peak traffic

* Resilience - Resilience is how many faults a system can tolerate and how the system bounce back in case of failures.
* Retries with backoff - 
``` 
int waitinMillins  = 20000;
	Thread.sleep(waitinMillins);
	switch(response.StatusCode){
		case HttpStatusCode.Ok:
			 retry = false;
			 break;
		case HttpStatusCode.GatewayTimeOut:
			 retry = true;
			 break;
	}
```
	
#### 31. Resilience4j

* Resilience4j is an alternative for hystrix server which helps in fault tolerence of our micro service application.
* Resilience4j features are Circuit breaker (fault tolerance), Rate Limiter (block too frequent requests), Time Limiter (Set time limit when calling remote operation), Retry mechanism (Automatically retry a failed remote operation), Bulkhead(Avoid too many concurrent requests), Cache(Store ), Cache(Store results of costly remote operations).
* In circuit breaker there are 3 states available closed, open and half open. Closed means, electricity is flowing in the circuuits and it is fine. When we have multiple requests and there is failure of more than 50%(the created treshold value), in such case we the state will move to open and give alets that there is an issue with the servic. If the requests are failing, then the state will changeto open and keep checking for the service to come back. Once the issue is resolved and the responses are coming, then the state will again change to closed.
* To work with resilience4j, we need to add 3 dependencies aop, actuator and resilience4j apis. Actuator is to get the health metrics of the service, aop is to send the captured metrics and resilience api is to implement the circutir breaker.
	
```
We need to annnotate with the Circuit breaker service as below.
@CircuitBreaker(name = CERCUITE_BREAKER_SERVICE.fallbackMethod = "getAllAvailableProducts")
```

* In our application.yaml file, we need to enable all circuit breakers.
* Configure resilience4j.circuitbreaker in application.yaml file.
	
#### 32. Micrometer

Micrometer provides a simple facade to integrate actuator metrics with externl monitoring system and it allows us to instrument your JVM based application. It supports several monitoring systems like Netflix Atlas, AWS cloud watch, Datadog, Influx data, SignalFX, Graphite, Wavefront, Prometheus etc. 
	
#### 33. Prometheus
Prometheus is an opensource monitoring system that was originally built by SoundCloud. It consist of the following core components.
	* A data scraper that pulls metrics data over HTTP periodically at a configured interval.
	* A time series database to store all metrics data.
	* A simple user interface where you can visualize, query and monitor all the metrics.

#### 34. Grafana
Grafana allows you to bring data from various data sources like Elastic search, Prometheus, Graphite, InfluxDB etc. and visualize them with beautiful graphs. It also lets you set alert rules based on your metrics data. When an alert changes state, it can notify you over email, slack, or various other channels.

#### 35. Splunk 
* Splunk is an innovative technology which searches and indexes log files and helps organizations derive insights from the data. A main benefit of Splunk is that it uses indexes to store data, and so does not require a separate database to store its information.
* Using splunk we can analyze logs in real time environment in web interface. Apart from logs splunk also provides many other features like monitoring, alerts etc.
* To enable splunk logs, we need to add splunk configurations including server,index etc. Also need to add splunk libraries in our pom.xml file.
* We can search the logs using the index we have configured and a keyword of our choice. We can also filter the logs timely like last 15 mins, last one hour, one week or one month etc.
* Splunk also supports configuring the alerts based on the criteria. In Settings, we need to create the criteria and configure the SMTP details. So that when the criteria matches, alerts will be triggered to the configured mail id.

#### 36. Spring and JPA Transactions

Basically, there are two distinct ways to configure Transactions, annotations and AOP, each with its own advantages.

* **@Transactional** - With transactions configured, we can now annotate a bean with @transactional either at the class or method level. This annotation supports further configurations like propagation type, isolation level, timeout for the operation, readonly flag and also the rollback rules of the transaction. By default rollback happens for runtime and unchecked exceptions only. The checked exceptions does not trigger a rollback. However we can configure this behavior with the rollbackFor and noRollbackFor parameters. Only public methods should be annotated with @Transactional. Methods of any other visibility would be simply ignored. 

* **@EnableTransactionManagement** - Spring introduced this annotation to use in a configuration class to enable transactional support.If we are using spring boot and have a spring-data or spring-tx dependencies on the class path, then transaction management will be enabled by defult.

* At high level, spring creates proxies for all the classes annotated with @Transactional either on the class or any of the methods. 

#### 37. Spring Security
Security is nothing but the restricting the application access and functionalities. It provides both authentication and authorization. Security can be provided with different levels.
* Username and Password authentication.
* SSO/Okta/LDAP
* App Level authorization
* Intra app authorization like OAuth
* Micro service security (using tokens or JWT)
* Method level security 
* 5 core concepts in Sprin security are i. Authentication ii. Authorization iii. Principal iv. Granted Authority v. Roles

- **Authentication and Authorization-** Authentication is nothing but the identity to enter into the system. Authorization is the accessibility to perform cetain things in the system. Authentication can be knowledge based or pocession based. Knowledge based authentication is like username/password or the code to enter. Pocession based authentication is the smss otp or software or hardware token etc.
- **Principal-** Currently logged in user. Once the user is authentiated an entered into the system, app assigns a unique principal to the user in the context.
- **Roles and Authorities-** Roles are cooarse grained permissions or grouping of authorities. Fine grained permissions are authorities.

- **Adding Spring security to a spring boot application**.
* If we add spring-boot-starter-security dependency to an applicationm it adds the security by default. Basically it adds interceptor filters and expects authentication to access each URL. By default, spring security will add certain thigs. It does not add authentication to certain urls like error pages. Because it doesn't need authentication to show error pages.
	- Adds mandatory authentication for URLs/ apis
	- It adds a login form
	- Handles login errors
	- Creates a default user and password, if the user doesn't provide any credentials. Default created user will be "user" and generated password will be printed in console. We can provide the user name and password by adding the same in application.yaml file.
	```
	spring:
		security:
			user:
				name: admin
				password: admin
	```
* Configuring Security using Authentication Manager 
	- We create a configuration class which extends the WebSecurity configuration and here we can override the required methods and can add in-memory users allowed for authentication. Also we can add a been for Password encoder to encode the password and not allow clear text passwords.
	-
* Configuring Authorization in Spring security
	- In Configuration class, we can enable the authorization by adding the access levels of different APIs with user roles.
	```
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /*.antMatchers("/","static/css","static/js").permitAll()
                .antMatchers("/**").hasAnyRole()*/
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin();

    }
	```
* How does Speing Security works 
	- Spring security works with the concept of filters added in servlets.
	- In normal spring application, to implement security we need to addd the filter "org.springframework.web.filter.DelegatingFilterProxy" configurations manually in web.xml
	- If we are working in spring boot application it automatically adds required dependencies.

* Authentication Manager interface
	- It is a core interface that spring security uses for the authentication process. It has only one method authenticate which when implemented in a class that implements an Authentication Manager has all the logic for authenticating a user request.
	- The authenticate method takes an “Authentication” object as its parameter and returns an “Authentication” object on successful authentication of the user or else we can have an exception thrown indicating that the user is not authenticated.
	- Authentication Filter intercepts the authentication request, creates authentication object, sets the credentials and passes it to the Authentication manager. Authentication manager, finds the appropriate provider using supports method. Authenticate method will call UserDetails service get the user details and authenticate the user. Then it creates an authentication object with user principal and passes the authentication object all way back to authentication filter. Once the authentication filter receives the authentication obejct with principal then it stores it in a local thread.

* Spring Boot and Spring Security with LDAP
	- LDAP stands for Light weight Directory Access Protocol. This is a protocol for accessing and maintaining distributed directory information over an Internet Protocol network. LDAP is used to maintain information of an organization. A common use of LDAP is to provide a central place to store usernames and passwords. This allows many different applications and servies to connect to the LDAP server for validation.
	- We can add ldap properties and configurations and enable the ldap authentication in Configuration class extending WebSecurity.
	- AD is active directory. It is used to authenticate and authorize all kind of comuters. AD is the active services database and LDAP is a way to talk to AD.
* Spring Boot Security with JWT
	- JWT stands for JSON Web Tokens. Auhorization strategies using tokens are i. Session token ii. JSON web token. The whole idea of JWT is sending some information to the server and the server will send the same information back to identify subsequent requests.
	- JWT token does consists of 3 parts i. Header ii. Payload/Body iii. Signature.
	- JWT is meant for authorization.
	
* Providing Security for Microservices - at gateway level
	- It is difficult and redundnt to provide the security at each service level in microservice environment. So we provide the security at API gateway level. But as per the architecture, gateway is just for routing the requests. So create a new service which can handle authentication and authorization of each service at gateway level.
	- We can also provide the scope for the accessibility of service. For example if we have an order service and payment service, we can restrict the access to call payment gateway service only from the order service and restrict the access from any other sources.

#### 38. Spring Batch
Spring Batch is one of the core modules of spring framework and using this we can create robust batch processing system.
* Key Components of Batch
	- **Job Launcher -** JobLauncher interface is used to launch spring batch jobs. This is an entry point to initiate any job.
	- **Job-** Once jabLauncher calls run() method, it creates another object called Job. Once JobLauncher intiates JOb, it calls another interface called Job repository which maintains the status of all the jobs whether it is success or fail.
	- **Step-** Each job will have multiple steps and each step will have 3 actors Item Reader, Item Writer and Item Processor. Item reader, reads the data from input. Item Processor processes the data and Item writer writes the data to destination.
	- Batch processing is used, when we want to process bulk data like dumping huge no of data files to data base or processing huge number of events,notifications or payments from backend.
	
#### 39. Spring Boot Thread pool
We can implement multi threading in spring boot using completable feature. Completable feature is introduced in Java8.Using [Generate Mock Data](https://www.mockaroo.com/) we can generate test data.
- **@EnableAsync-** This annotation informs springboot to run the application in the background.
- **CompletableFuture-** CompletableFuture is used for asynchronous programming in Java. Asynchronous programming is a means of writing non-blocking code by running a task on a separate thread than the main application thread and notifying the main thread about its progress, completion or failure.  
- **@Configuration-** Spring Boot lets you externalize your configuration so that you can work with the same application code in different environments. You can use properties files, YAML files, environment variables, and command-line arguments to externalize configuration.

## 40. Spring Interview Questions
- Spring framework is an open source application framework and inversion of control container written in java. This allows developers to focus on business logic. Spring is also very adoptable with many extention modules.
- Benefits of Spring framework are
	- **Lightweight** - It is lightweight in resource use.
	- **Scalable** - Spring's transaction management interface can scale to either a local transaction on a single database to global transactions using the JTA module.
	- **Excepion Handling** - Exception handling is easy.
	- **AOP** - Spring supports aspect oriented programming, a paradigm that seprates appplication business logic from system services.
- Modules of Spring framework
	- Spring Core, Spring Bean, SpEL, Spring Context, JDBC, ORM, OXM, JMS, Transaction, Web, Web MVC, Web Socket, WebPortlet etc.
- Different components of Spring application.
	- Spring application contains 5 components.
	- **Interface** - Defines program functions.
	- **Bean Class** - Contains properties, setter and getter methods for accessing the bean.
	- **Spring AOP** - Includes cross cutting concerns functionality. 
	- **Bean Configuration file** - Contains the information of classes, how to configure them  define their relationships.
	- **User program** - Calls functions across the program.
- **Spring IOC Container** - An IOC container creates, configures and connects objects while also managing their lifecycle. The cotainer gets instructions on these areas from configuration metadata given by the user.
- ** Different types of IOC** - 
	- Bean Factory Container - This factory class contains a prepackaged collection of beans that instantiate when called by clients. This is the most basic container to support DI. 
	- Applicaion Context Container - Built on top of the Bean Factory Container. This container provides additional enterprise focused functionalities.
- ** Different Bean sopes supported by Spring **
		- Singleton - Scopes a bean definition to be restricted to a single instance per container.
		- Prototype - Scopes a single bean to enable any number of instances.
		- Request - Scopes a bean definition to a single HTTP request within an application context.
		- Session - Scopes a bean definition to an HTTP session within an application context.
		- Global - session - Scopes a bean definition to a Global HTTP.
- ** Bean Lifecycle**
		- Instantiate - The bean is instantiated by the Spring container using the bean's definition.
		- Populate Properties - Spring populates all the defined properties from the XMl file using dependency injection.
		- Set Bean Name - Spring passes the bean's identifier to the setBeanName() method if bean uses the BeanNameAware interface.
		- Set Bean Factory - Spring passes the bean factory to the setBeanFactory() method if the bean is configured to use the BeanFactoryAware interface.
		- Pre Intialization - Spring calls any bean post processor associated with the bean using the postProcessorBeforeInitialization() method.
		- Initialization - The bean is then initialized. Any special initialization process specified in the init-method is followed.
		- Post Initialization - All defined postProcessAfterInitialization() methods are called. Now the bean is complete. Beans that implement DisposableBean will be deleted using destroy() after their job is finished.