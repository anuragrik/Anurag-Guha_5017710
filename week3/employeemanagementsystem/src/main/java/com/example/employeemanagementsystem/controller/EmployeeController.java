package week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.controller;
import week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.repository.EmployeeRepository;
import week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}