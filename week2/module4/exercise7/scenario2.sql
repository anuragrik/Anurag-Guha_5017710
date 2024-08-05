CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_position IN VARCHAR2, p_salary IN NUMBER, p_department IN VARCHAR2);
    PROCEDURE UpdateEmployee(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_salary IN NUMBER);
    FUNCTION CalculateAnnualSalary(p_employee_id IN NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_position IN VARCHAR2, p_salary IN NUMBER, p_department IN VARCHAR2) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_employee_id, p_name, p_position, p_salary, p_department, SYSDATE);
        COMMIT;
    END;

    PROCEDURE UpdateEmployee(p_employee_id IN NUMBER, p_name IN VARCHAR2, p_salary IN NUMBER) IS
    BEGIN
        UPDATE Employees
        SET Name = p_name, Salary = p_salary
        WHERE EmployeeID = p_employee_id;
        COMMIT;
    END;

    FUNCTION CalculateAnnualSalary(p_employee_id IN NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_employee_id;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
    END;
END EmployeeManagement;
/
