package week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.controller;

import week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.repository.DepartmentRepository;
import week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.model.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @GetMapping
    public Page<Department> getDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }
}


