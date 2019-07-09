package com.GermanExpats.SalaryRate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.GermanExpats.SalaryRate.entity.GermanEmployee;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<GermanEmployee, Integer>{

    //uses to update and delete tests
    @Query("SELECT MAX(GE.employeeId) FROM GermanEmployee as GE")
    public int getLastId();
}