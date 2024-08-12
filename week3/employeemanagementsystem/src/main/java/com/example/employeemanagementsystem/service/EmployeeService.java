package week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.service;

import week3.employeemanagementsystem.repository.EmployeeRepository;
import week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void batchSaveEmployees(List<Employee> employees) {
        int batchSize = 50; // Example batch size
        for (int i = 0; i < employees.size(); i++) {
            employeeRepository.save(employees.get(i));
            if (i % batchSize == 0 && i > 0) {
                // Flush a batch of inserts and release memory
                employeeRepository.flush();
                employeeRepository.clear();
            }
        }
    }
}

