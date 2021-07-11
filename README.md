## Solution Description
The project uses the following technologies:

* Java 
* Spring Boot
* Mysql
* Maven
* MapStruct
* Lombok



## The architecture

* The service uses Controller - Service - Repository pattern:
    * Controller: contains application logic and passing user input data to service
    * Service: The middleware between controller and repository. Gather data from controller, 
      business logic, and calling repositories for data manipulation.
    * Repository: layer for interaction with models and performing DB operations.
  
  
  ## Random Notes
   * I used mapstruct may be we can manibulate data before returning it like activeate boolean to string
   * The end points is down there in pictuers




Create:
![Create](https://i.imgur.com/tuf9Hxf.png)



readAll:
![readAll](https://i.imgur.com/I2lCx9a.png)



Update:
![Update](https://i.imgur.com/I2lCx9a.png)


de/activate:
![de/activate](https://i.imgur.com/MegyOX9.png)



Serve static image:
![image](https://i.imgur.com/uyDzykX.png)
