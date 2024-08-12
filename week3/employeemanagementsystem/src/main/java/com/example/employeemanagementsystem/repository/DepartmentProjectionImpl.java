package week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.repository;

public class DepartmentProjectionImpl implements DepartmentProjection {

    private Long id;
    private String name;
    private Integer employeeCount;

    public DepartmentProjectionImpl(Long id, String name, Integer employeeCount) {
        this.id = id;
        this.name = name;
        this.employeeCount = employeeCount;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getEmployeeCount() {
        return employeeCount;
    }
}

