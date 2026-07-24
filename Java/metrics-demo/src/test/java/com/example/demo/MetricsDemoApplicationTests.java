package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class MetricsDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void testHelloEndpoint() throws Exception {
		mockMvc.perform(get("/api/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string("Hello from Metrics Demo!"));
	}

	@Test
	void testGreetingEndpoint() throws Exception {
		mockMvc.perform(get("/api/greeting/John"))
			.andExpect(status().isOk())
			.andExpect(content().string("Hello, John!"));
	}

	@Test
	void testHealthEndpoint() throws Exception {
		mockMvc.perform(get("/api/health"))
			.andExpect(status().isOk())
			.andExpect(content().string("Application is healthy!"));
	}

	@Test
	void testActuatorHealth() throws Exception {
		mockMvc.perform(get("/actuator/health"))
			.andExpect(status().isOk());
	}

	@Test
	void testActuatorMetrics() throws Exception {
		mockMvc.perform(get("/actuator/metrics"))
			.andExpect(status().isOk());
	}

	@Test
	void testPrometheusEndpoint() throws Exception {
		mockMvc.perform(get("/actuator/prometheus"))
			.andExpect(status().isOk());
	}

}
