# Employee Management

A simple Spring Boot 4 application demonstrating employee management operations with unit testing and JaCoCo code coverage.

## Project Overview

This project includes:
- Spring Boot 4 application using Java 21
- A simple employee domain model
- Service layer with constructor injection
- Repository contract for persistence
- Unit tests with JUnit 5 and Mockito
- JaCoCo configuration to generate coverage reports

## Build Instructions

Run the following command from the `employee-management` folder:

```bash
mvn clean package
```

## Run Tests

Execute tests with:

```bash
mvn test
```

## Generate JaCoCo Report

The JaCoCo report is generated automatically during the Maven `package` phase.
To explicitly run only the coverage report, use:

```bash
mvn test jacoco:report
```

## Report Location

After running tests and generating the report, view the HTML report at:

```
target/site/jacoco/index.html
```

## Notes

The provided unit tests intentionally do not cover every branch, ensuring the JaCoCo report shows some uncovered code.
