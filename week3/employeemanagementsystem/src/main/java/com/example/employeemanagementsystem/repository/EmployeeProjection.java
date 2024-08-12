package week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.repository;

import org.springframework.beans.factory.annotation.Value;

import week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.model.Employee;

public interface EmployeeProjection {

    Long getId();
    String getName();
    String getEmail();

    @Value("#{target.department.name}")
    String getDepartmentName();
}

