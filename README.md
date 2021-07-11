## Solution Description
The project uses the following technologies:

* Java 
* Spring Boot
* Mysql
* Maven
* MapStruct
* Lombok

## Important Note
   * Please add api/v1 before any route 


## The architecture

* The service uses Controller - Service - Repository pattern:
    * Controller: contains application logic and passing user input data to service
    * Service: The middleware between controller and repository. Gather data from controller, 
      business logic, and calling repositories for data manipulation.
    * Repository: layer for interaction with models and performing DB operations.
  
  
  ## Random Notes
   * I used mapstruct may be we can manibulate data before returning it like activeate boolean to string
   * The end points is down there in pictuers




Create:  "api/v1"
![Create](https://i.imgur.com/tuf9Hxf.png)



readAll: "api/v1"
![readAll](https://i.imgur.com/I2lCx9a.png)



Update:  "api/v1"
![Update](https://i.imgur.com/I2lCx9a.png)


de/activate: "api/v1"
![de/activate](https://i.imgur.com/MegyOX9.png)



Serve static image: "api/v1"
![image](https://i.imgur.com/uyDzykX.png)
