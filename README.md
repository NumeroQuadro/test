# Test Microservice (Java)

This is a starter microservice template with Gradle, Spring Boot, Docker, and unit tests. Extend it for your own tasks.

## Requirements

- JDK 21 or newer
- Docker (optional, for container runs)

## Gradle usage

- List tasks: `./gradlew tasks`
- Run app: `./gradlew bootRun`
- Run tests: `./gradlew test`
- Build jar: `./gradlew clean bootJar`
- Full build: `./gradlew clean build`

## Run locally

- Start the service: `./gradlew bootRun`
- Ping: `GET http://localhost:8080/api/v1/ping`
- Echo: `POST http://localhost:8080/api/v1/echo`

Example request body:

```
{
  "message": "hello"
}
```

## Docker

- Build image: `docker build -t test-microservice .`
- Run image: `docker run -p 8080:8080 test-microservice`
- Compose: `docker compose up --build`

## Project structure

- `src/main/java/com/example/testservice` application code
- `src/main/resources` configuration
- `src/test/java/com/example/testservice` unit tests

## Writing unit tests (step-by-step)

- Create a test class under `src/test/java` with the same package as the class you test.
- Name the class `ClassNameTest`.
- Use JUnit 5 annotations like `@Test`.
- For unit tests, instantiate the class under test and mock its dependencies with Mockito.
- Use clear method names that describe behavior.
- Keep one behavior per test.
- Run tests with `./gradlew test`.

Template:

```
package com.example.testservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class ExampleServiceTest {

    @Test
    void methodReturnsExpectedValue() {
        Dependency dependency = mock(Dependency.class);
        when(dependency.value()).thenReturn("expected");

        ExampleService service = new ExampleService(dependency);

        String result = service.method();

        assertEquals("expected", result);
    }
}
```

## Parser skeleton

- Base interface: `Parser<T>` in `src/main/java/com/example/testservice/parser`.
- Example implementation: `KeyValueParser` parses `key=value` lines into a `Map`.
- Custom parser flow: create a class that implements `Parser<T>` and add tests under `src/test/java`.

Example usage:

```
KeyValueParser parser = new KeyValueParser();
Map<String, String> result = parser.parse("name=service\nversion=1");
```

## Writing parser tests

- Create a test class `YourParserTest` in `src/test/java/com/example/testservice/parser`.
- Use `@Test` methods for each behavior.
- Include a success case and at least one invalid input case.
- Run with `./gradlew test`.
