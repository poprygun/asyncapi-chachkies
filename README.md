# Experiment with using asyncAPI generating Spring Cloud Applications

**Generated source contained dependencies set that differed from what was expected based on start.spring.io generator.  application.yml config also looked a bit off.  Could potentially be related to the fact that asyncAPI is a bit behind in Spring Boot versions support.**

Generated app failed to start with the error `IllegalArgumentException: Type must be one of Supplier, Function or Consumer`

## Generate subscriber

 ```bash
 mkdir sub && cd sub
 
ag ../spec/subscriber.yml @asyncapi/java-spring-cloud-stream-template -p actuator=true -p groupId=io.microsamples.asyncapi -p javaPackage=io.microsamples.assyncapi -p reactive=true -p binder=rabbit -p springBootVersion=2.4.5 -p springCloudVersion=2020.0.2 --force-write
 ```

## Generate publisher

```bash

mkdir pub && cs pub

ag ../spec/publisher.yml @asyncapi/java-spring-cloud-stream-template -p actuator=true -p groupId=io.microsamples.asyncapi -p javaPackage=io.microsamples.assyncapi -p reactive=true -p binder=rabbit -p springBootVersion=2.4.5 -p springCloudVersion=2020.0.2 --force-write
```
