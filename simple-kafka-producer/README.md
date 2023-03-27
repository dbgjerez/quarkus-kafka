# simple-kafka-producer Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
mvn compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
mvn package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can run the native executable build in a container using: 

```shell script
mvn package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/simple-kafka-producer-1.0.0-SNAPSHOT-runner`

## Creating a native container

After a native compilation, you can build the image: 

```shell script
podman build -f src/main/docker/Dockerfile.native-micro -t quay.io/dborrego/simple-kafka-producer .
```

## Container

[https://quay.io/repository/dborrego/simple-kafka-producer](https://quay.io/repository/dborrego/simple-kafka-producer)