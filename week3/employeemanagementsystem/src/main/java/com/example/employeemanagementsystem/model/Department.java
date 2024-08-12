package week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.model;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import lombok.Data;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "departments")
@Data
@NamedQueries({
    @NamedQuery(name = "Department.findByName",
                query = "SELECT d FROM Department d WHERE d.name = :name"),
    @NamedQuery(name = "Department.findDepartmentsWithEmployeeCountGreaterThan",
                query = "SELECT d FROM Department d WHERE (SELECT COUNT(e) FROM Employee e WHERE e.department.id = d.id) > :minEmployeeCount")
})
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT) // Example of Hibernate-specific fetch mode
    @BatchSize(size = 10) // Example of Hibernate-specific batch size
    private List<Employee> employees;

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

