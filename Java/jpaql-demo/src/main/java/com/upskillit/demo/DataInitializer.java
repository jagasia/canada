package com.upskillit.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.upskillit.demo.entity.Employee;
import com.upskillit.demo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
	private final EmployeeRepository r;

	public void run(String... a) {
		if (r.count() > 0)
			return;
		String[] d = { "IT", "HR", "Finance", "Sales" };
		for (int i = 1; i <= 20; i++) {
			Employee e = new Employee();
			e.setName("Employee " + i);
			e.setDepartment(d[(i - 1) % 4]);
			e.setSalary(30000.0 + i * 1000);
			r.save(e);
		}
	}
}