
package com.canadalife.demo.repository; import org.springframework.data.mongodb.repository.MongoRepository; import com.canadalife.demo.document.Employee;
public interface EmployeeRepository extends MongoRepository<Employee,String>{}
