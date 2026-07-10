package com.upskillit.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upskillit.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query("select sum(e.salary) from Employee e where e.department=:department")
	Double findSumOfSalaryByDepartment(@Param("department") String department);
	
	@Query(value = "SELECT MIN(E.SALARY) FROM EMPLOYEE E WHERE E.DEPARTMENT=:department", nativeQuery = true)
	Double findMinSalaryByDept(@Param("") String department);
}