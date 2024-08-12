package week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.model.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(name = "Employee.findByEmail")
    Employee findByEmail(@Param("email") String email);

    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);

    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAll(Sort sort);

    @Query("SELECT e.id AS id, e.name AS name, e.email AS email, e.department.name AS departmentName " +
           "FROM Employee e WHERE e.department.name = :departmentName")
    List<EmployeeProjection> findEmployeeProjectionsByDepartmentName(@Param("departmentName") String departmentName);
}


