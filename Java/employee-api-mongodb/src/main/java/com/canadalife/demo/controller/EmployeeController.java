
package com.canadalife.demo.controller; import java.util.*; import org.springframework.web.bind.annotation.*; import lombok.RequiredArgsConstructor; import com.canadalife.demo.document.Employee; import com.canadalife.demo.service.EmployeeService;
@RestController @RequestMapping("/employees") @RequiredArgsConstructor
public class EmployeeController{private final EmployeeService s; @PostMapping public Employee c(@RequestBody Employee e){return s.create(e);} @GetMapping public List<Employee> r(){return s.read();} @GetMapping("/{id}") public Optional<Employee> g(@PathVariable String id){return s.read(id);} @PutMapping public Employee u(@RequestBody Employee e){return s.update(e);} @DeleteMapping("/{id}") public void d(@PathVariable String id){s.delete(id);}}
