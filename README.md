 
 ## Generate subscriber

 ```bash
 mkdir sub && cd sub
 
ag ../spec/subscriber.yml @asyncapi/java-spring-cloud-stream-template -p actuator=true -p groupId=io.microsamples.asyncapi -p javaPackage=io.microsamples.assyncapi -p reactive=true --force-write
 ```

## Generate publisher

```bash

mkdir pub && cs pub

ag ../spec/publisher.yml @asyncapi/java-spring-cloud-stream-template -p actuator=true -p groupId=io.microsamples.asyncapi -p javaPackage=io.microsamples.assyncapi -p reactive=true -p binder=rabbit --force-write
```