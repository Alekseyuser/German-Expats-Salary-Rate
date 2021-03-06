package com.GermanExpats.SalaryRate.service;

import com.GermanExpats.SalaryRate.entity.GermanEmployee;
import com.GermanExpats.SalaryRate.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;


@Service
public class GermanEmployeeService implements IGermanEmployeeService {




    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * @return list of all employees from DB
     */

    @Override
    public Page<GermanEmployee> getAllEmployees(int page) {
        return employeeRepository.findAll(PageRequest.of(page,10));
    }

    /**
     * @param employeeId - each employee(line in DB) has unique ID
     * @return all information about employee based on his id
     */

    @Override
    public GermanEmployee getEmployeeById(int employeeId) {
        if(employeeRepository.existsById(employeeId))
            return employeeRepository.findById(employeeId).get();
        else
            //Exception API for non-exist id in the DB
            throw new EntityNotFoundException();
    }

    /**
     * @param employee include all fields without id. Id is autogenerated. Json example:
     *                 {"date_point":"12/13/2016 14:19","age":1,"sex":"m","city":"Berlin",
     *                 "position":"test","experience_in_Europe":1,"total_experience":3,"salary":54000,
     *                 "salary_1_year_ago":48000,"first_europe_salary":48000,
     *                 "number_of_job_in_europe":1,"work_language":"test","company_size":"50-100",
     *                 "company_type":"startup","level":"Senior"}
     */

    @Override
    public void addEmployee(GermanEmployee employee) {
        employeeRepository.save(employee);
    }

    /**
     * @param employee include all fields. Line with same id in DB will be replaced.
     */

    @Override
    public void updateEmployee(GermanEmployee employee) {
        GermanEmployee emp = employeeRepository.findById(employee.getId())
                .orElseThrow(() -> new EntityNotFoundException());

        emp.setAge(employee.getAge());
        emp.setCity(employee.getCity());
        emp.setCompany_size(employee.getCompany_size());
        emp.setCompany_type(employee.getCompany_type());
        emp.setDate_point(employee.getDate_point());
        emp.setExperience_in_Europe(employee.getExperience_in_Europe());
        emp.setFirst_europe_salary(employee.getFirst_europe_salary());
        emp.setId(employee.getId());
        emp.setLevel(employee.getLevel());
        emp.setNumber_of_job_in_europe(employee.getNumber_of_job_in_europe());
        emp.setPosition(employee.getPosition());
        emp.setSalary(employee.getSalary());
        emp.setSalary_1_year_ago(employee.getSalary_1_year_ago());
        emp.setSex(employee.getSex());
        emp.setTotal_experience(employee.getTotal_experience());
        emp.setWork_language(employee.getWork_language());
        employeeRepository.save(emp);
    }

    /**
     * @param employeeId of employee to delete.
     */

    @Override
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    /**
     * @return last possible id from DB. Uses for testing.
     */
    @Override
    public int getLastId() {
        //return germanEmployeeDAO.getLastId();
        return employeeRepository.getLastId();
    }

}
