# Metrics Demo - Spring Boot Application

A Spring Boot application demonstrating logging, metrics collection, and observability features using Spring Boot Actuator, Micrometer, and Prometheus.

## Features

- **Spring Boot 3.3.1** with Java 21
- **Logging** with SLF4J and Logback
- **Metrics Collection** using Micrometer
- **Prometheus Support** for metrics export
- **Distributed Tracing** with Micrometer Tracing and Brave
- **Actuator Endpoints** for health, metrics, and info
- **Spring DevTools** for development productivity

## Project Structure

```
metrics-demo/
├── pom.xml                                    # Maven configuration
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── MetricsDemoApplication.java   # Main Spring Boot application
│   │   │   └── controller/
│   │   │       └── MetricsController.java    # REST endpoints for demo
│   │   └── resources/
│   │       └── application.yml               # Application configuration
│   └── test/
│       └── java/com/example/demo/
│           └── MetricsDemoApplicationTests.java
└── logs/                                      # Application logs directory
```

## Available Endpoints

### API Endpoints

1. **Hello Endpoint**
   ```
   GET /api/hello
   ```
   Returns a simple greeting message.

2. **Greeting Endpoint**
   ```
   GET /api/greeting/{name}
   ```
   Returns a personalized greeting.

3. **Health Check**
   ```
   GET /api/health
   ```
   Returns application health status.

4. **Process Endpoint**
   ```
   GET /api/process/{duration}
   ```
   Simulates processing for a specified duration (in milliseconds).

### Actuator Endpoints

1. **Health Check**
   ```
   GET /actuator/health
   ```
   Returns detailed health information.

2. **Application Info**
   ```
   GET /actuator/info
   ```
   Returns application information.

3. **Metrics List**
   ```
   GET /actuator/metrics
   ```
   Lists all available metrics.

4. **Specific Metric**
   ```
   GET /actuator/metrics/{metric-name}
   ```
   Returns specific metric details.

5. **Prometheus Metrics**
   ```
   GET /actuator/prometheus
   ```
   Exports metrics in Prometheus format.

## Key Metrics Tracked

- `api.hello.calls` - Counter for hello endpoint calls
- `api.greeting.calls` - Counter for greeting endpoint calls
- `api.greeting.name.length` - Gauge for greeting name length
- `api.health.checks` - Counter for health check calls
- `api.process.duration` - Timer for processing request duration
- Standard JVM metrics (memory, threads, garbage collection, etc.)

## Logging Configuration

The application uses SLF4J with Logback backend:

- **Root Level**: INFO
- **Application Level** (`com.example.demo`): DEBUG
- **Spring Framework Level**: INFO
- **Spring Web Level**: DEBUG

Logs are written to both:
- **Console**: With timestamp and formatted output
- **File**: `logs/metrics-demo.log`

## Building the Application

### Prerequisites
- Java 21 or later
- Maven 3.6.0 or later

### Build Commands

```bash
# Build the application
mvn clean package

# Run tests
mvn test

# Run the application
mvn spring-boot:run
```

## Running the Application

```bash
# Using Maven
mvn spring-boot:run

# Or using the generated JAR
java -jar target/metrics-demo-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

## Testing the Application

```bash
# Test hello endpoint
curl http://localhost:8080/api/hello

# Test greeting endpoint
curl http://localhost:8080/api/greeting/Alice

# Test health endpoint
curl http://localhost:8080/api/health

# Test process endpoint (5 second simulation)
curl http://localhost:8080/api/process/5000

# View application health
curl http://localhost:8080/actuator/health

# View metrics list
curl http://localhost:8080/actuator/metrics

# View Prometheus metrics
curl http://localhost:8080/actuator/prometheus
```

## Dependencies

### Core Dependencies
- `spring-boot-starter-web` - Web application support
- `spring-boot-starter-actuator` - Actuator for monitoring
- `spring-boot-starter-logging` - Logging support

### Observability Dependencies
- `micrometer-core` - Metrics instrumentation
- `micrometer-registry-prometheus` - Prometheus metrics export
- `micrometer-tracing-bridge-brave` - Distributed tracing
- `zipkin-reporter-brave` - Zipkin trace reporting

### Development Dependencies
- `spring-boot-devtools` - Development tools for hot reload
- `spring-boot-starter-test` - Testing framework

## Configuration

Edit `src/main/resources/application.yml` to customize:

- Server port
- Logging levels
- Metrics export settings
- Actuator endpoint exposure
- Application name and properties

## Observability Stack

This application demonstrates a complete observability stack:

1. **Logging** - Structured logs with context
2. **Metrics** - Application and system metrics collection
3. **Tracing** - Distributed request tracing with Brave/Zipkin
4. **Health Checks** - Custom and automated health indicators

## Next Steps

To extend this application:

1. Add custom metrics for business logic
2. Configure Prometheus for metrics collection
3. Setup Grafana for metrics visualization
4. Configure Zipkin for distributed tracing
5. Integrate with centralized logging (ELK, Splunk, etc.)

---

**Project**: metrics-demo  
**Java Version**: 21  
**Spring Boot Version**: 3.3.1  
**Package Manager**: Maven
