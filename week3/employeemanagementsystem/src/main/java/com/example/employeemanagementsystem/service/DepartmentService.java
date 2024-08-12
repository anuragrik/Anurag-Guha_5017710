package week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.service;

import week3.employeemanagementsystem.repository.DepartmentRepository;
import week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.model.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public void batchSaveDepartments(List<Department> departments) {
        int batchSize = 50; // Example batch size
        for (int i = 0; i < departments.size(); i++) {
            departmentRepository.save(departments.get(i));
            if (i % batchSize == 0 && i > 0) {
                // Flush a batch of inserts and release memory
                departmentRepository.flush();
                departmentRepository.clear();
            }
        }
    }
}

