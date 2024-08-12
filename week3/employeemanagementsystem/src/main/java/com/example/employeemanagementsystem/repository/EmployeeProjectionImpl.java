package week3.employeemanagementsystem.src.main.java.com.example.employeemanagementsystem.repository;

public class EmployeeProjectionImpl implements EmployeeProjection {

    private Long id;
    private String name;
    private String email;
    private String departmentName;

    public EmployeeProjectionImpl(Long id, String name, String email, String departmentName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
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
    public String getEmail() {
        return email;
    }

    @Override
    public String getDepartmentName() {
        return departmentName;
    }
}

