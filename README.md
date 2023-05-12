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
	Attach the method defined inside controller to any of the end points.
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
 
 