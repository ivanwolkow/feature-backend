# Feature Backend

This is a Feature Backend solution providing API to work with "features".
It's been made with the following assumptions:

- Authentication and authorization are out of scope of this problem
- API documentation like Swagger is out of scope of this task
- Source data file is small enough to keep it inside static resources
- Source data file never changes as it would require the whole app to be rebuilt

## Build and run

Build fat jar with dependencies:

```bash
./gradlew check bootJar
```

Run the application:
```bash
java -jar build/libs/feature-backend-0.0.1-SNAPSHOT.jar
```

Build and run as a docker container:
```bash
docker build -t feature-backend .
docker run --rm -p 8080:8080 feature-backend
```

