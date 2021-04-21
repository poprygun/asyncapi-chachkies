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

## Run Microcks

### Configure Minikube

```bash
helm repo add strimzi https://strimzi.io/charts/
helm repo add microcks https://microcks.io/helm

minikube start --memory=10240 --cpus=4 --addons=ingress --addons=dashboard --addons=dashboard --addons=storage-provisioner



```
kubectl create namespace microcks

helm install strimzi strimzi/strimzi-kafka-operator --namespace microcks

helm install microcks microcks/microcks --namespace=microcks \
    --set appName=microcks --set features.async.enabled=true \
    --set microcks.url=microcks.$(minikube ip).nip.io \
    --set keycloak.url=keycloak.$(minikube ip).nip.io \
    --set features.async.kafka.url=$(minikube ip).nip.io

Microcks is available at https://microcks.192.168.64.38.nip.io.

Keycloak has been deployed on https://keycloak.192.168.64.38.nip.io/auth to protect user access.
You may want to configure an Identity Provider or add some users for your Microcks installation by login in using the
username and password found into 'microcks-keycloak-admin' secret.

Kafka broker has been deployed on microcks-kafka.192.168.64.38.nip.io.
It has been exposed using TLS passthrough of the Ingress controller, you shoud extract the certificate for your client using:

kubectl get secret microcks-kafka-cluster-ca-cert -o jsonpath='{.data.ca\.crt}' -n microcks | base64 -d > ca.crt
```

kubectl get secret microcks-keycloak-admin --namespace=microcks -o jsonpath='{.data}'
{"password":"WGo4aEdzV0RqeWZkVG5nTVltUjNqdHZuQUJrWEdOb2Q4Q3BTOENJZQ==","postgresPassword":"dGN3cEJ4cExHRXpYTG1BajJJb3JCUHdFcnpjRFRJNks=","postgresUsername":"dXNlclA=","username":"YWRtaW4="}%

echo 'YWRtaW4=' | base64 --decode
admin%

echo 'eW5UcFM3cGcxakp3SDg1a01BNVVNMEZuVG9qeE52YW5Fd2lCSzBySw==' | base64 --decode
Xj8hGsWDjyfdTngMYmR3jtvnABkXGNod8CpS8CIe%

from kafka pod

bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic UsersigneupAPI_0.1.1_user-signeup --from-beginning


## Resources

[AsyncAPI Playground](https://playground.asyncapi.io/)