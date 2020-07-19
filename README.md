# springbootEurekaDemo

it had three service each service should build independently.

navigate Discoveryservice and run `mvn install` or directly run `mvn spring-boot:run`
navigate orderservice and run `mvn install` or directly run `mvn spring-boot:run`
navigate Userservice and run `mvn install` or directly run `mvn spring-boot:run`

Discoveryservice is discovery server and remaining to are DiscoveryClients.
once all service are running just check in localhost:8761 you can see eureka dashboard and all clients are in Application section.
