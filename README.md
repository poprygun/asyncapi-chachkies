 
 ## Generate subscriber

 ```bash
 mkdir sub && cd sub
 
ag ../spec/subscriber.yml @asyncapi/java-spring-cloud-stream-template -p actuator=true -p groupId=io.microsamples.asyncapi -p javaPackage=io.microsamples.assyncapi -p reactive=true -p binder=rabbit
 ```

## Generate publisher

```bash

mkdir pub && cs pub

ag ../spec/publisher.yml @asyncapi/java-spring-cloud-stream-template -p actuator=true -p groupId=io.microsamples.asyncapi -p javaPackage=io.microsamples.assyncapi -p reactive=true -p binder=rabbit
```


ag -p binder=rabbit -p artifactId=ExampleArtifactId -p groupId=com.example -p javaPackage=com.example.foo -p solaceSpringCloudVersion=1.0.0 -p springCloudStreamVersion=Horsham.SR3 -p springCloudVersion=Hoxton.SR3 ../spec/streetlights.yml @asyncapi/java-spring-cloud-stream-template
