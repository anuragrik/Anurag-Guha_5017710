package week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.repository;

import org.springframework.beans.factory.annotation.Value;

import week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.model.Department;

public interface DepartmentProjection {

    Long getId();
    String getName();

    @Value("#{target.employees.size()}")
    Integer getEmployeeCount();
}

