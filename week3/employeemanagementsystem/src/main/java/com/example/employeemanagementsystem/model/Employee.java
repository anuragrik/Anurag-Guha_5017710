package week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import lombok.Data;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "employees")
@Data
@NamedQueries({
    @NamedQuery(name = "Employee.findByEmail",
                query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByDepartmentName",
                query = "SELECT e FROM Employee e WHERE e.department.name = :departmentName")
})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @Fetch(FetchMode.SELECT) 
    @BatchSize(size = 10) 
    private Department department;

    @JoinColumn(name = "department_id")
    private Department department;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @LastModifiedBy
    @Column(nullable = false)
    private String lastModifiedBy;

    @CreatedBy
    @Column(nullable = false, updatable = false)
    private String createdBy;
}
