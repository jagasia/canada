package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
@RequestMapping("/api")
public class MetricsController {

	private static final Logger logger = LoggerFactory.getLogger(MetricsController.class);
	private final MeterRegistry meterRegistry;

	public MetricsController(MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
	}

	@GetMapping("/hello")
	public String hello() {
		logger.info("Hello endpoint called");
		meterRegistry.counter("api.hello.calls").increment();
		return "Hello from Metrics Demo!";
	}

	@GetMapping("/greeting/{name}")
	public String greeting(@PathVariable String name) {
		logger.info("Greeting endpoint called with name: {}", name);
		meterRegistry.counter("api.greeting.calls").increment();
		meterRegistry.gauge("api.greeting.name.length", name.length());
		return "Hello, " + name + "!";
	}

	@GetMapping("/health")
	public String health() {
		logger.debug("Health check endpoint called");
		meterRegistry.counter("api.health.checks").increment();
		return "Application is healthy!";
	}

	@GetMapping("/process/{duration}")
	public String processRequest(@PathVariable long duration) {
		logger.info("Processing request for {} ms", duration);
		long startTime = System.currentTimeMillis();
		
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			logger.error("Processing interrupted", e);
			Thread.currentThread().interrupt();
		}
		
		long elapsedTime = System.currentTimeMillis() - startTime;
		meterRegistry.timer("api.process.duration").record(java.time.Duration.ofMillis(elapsedTime));
		logger.info("Request processing completed in {} ms", elapsedTime);
		
		return "Processed for " + elapsedTime + " ms";
	}

}
