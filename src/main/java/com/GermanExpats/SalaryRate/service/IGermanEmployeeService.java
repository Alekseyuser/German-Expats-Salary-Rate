package com.GermanExpats.SalaryRate.service;

import java.util.List;
import com.GermanExpats.SalaryRate.entity.GermanEmployee;

public interface IGermanEmployeeService {

    List<GermanEmployee> getAllEmployees();
    GermanEmployee getEmployeeById(int employeeId);
    void addEmployee(GermanEmployee employee);
    void updateEmployee(GermanEmployee employee);
    void deleteEmployee(int employeeId);
    int getLastId();
}
