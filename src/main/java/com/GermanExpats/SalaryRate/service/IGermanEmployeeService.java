package com.GermanExpats.SalaryRate.service;

import java.util.List;
import com.GermanExpats.SalaryRate.entity.GermanEmployee;
import org.springframework.data.domain.Page;

public interface IGermanEmployeeService {

    Page<GermanEmployee> getAllEmployees(int page);
    GermanEmployee getEmployeeById(int employeeId);
    void addEmployee(GermanEmployee employee);
    void updateEmployee(GermanEmployee employee);
    void deleteEmployee(int employeeId);
    int getLastId();
}
