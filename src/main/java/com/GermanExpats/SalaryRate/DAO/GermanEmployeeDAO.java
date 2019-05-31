package com.GermanExpats.SalaryRate.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.GermanExpats.SalaryRate.entity.GermanEmployee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Transactional
@Repository
public class GermanEmployeeDAO implements IGermanEmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger logger = LogManager.getLogger(GermanEmployeeDAO.class);

    @Override
    public List<GermanEmployee> getAllEmployees() {
        String hql = "FROM GermanEmployee as GE ORDER BY GE.id";
        return (List<GermanEmployee>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public GermanEmployee getEmployeeById(int employeeId) {
        return entityManager.find(GermanEmployee.class, employeeId);
    }

    @Override
    public void addEmployee(GermanEmployee employee) {
        entityManager.persist(employee);
    }

    @Override
    public void updateEmployee(GermanEmployee employee) {
        GermanEmployee germanEmployee = getEmployeeById(employee.getId());
        germanEmployee.setAge(employee.getAge());
        germanEmployee.setCity(employee.getCity());
        germanEmployee.setCompany_size(employee.getCompany_size());
        germanEmployee.setCompany_type(employee.getCompany_type());
        germanEmployee.setDate_point(employee.getDate_point());
        germanEmployee.setExperience_in_Europe(employee.getExperience_in_Europe());
        germanEmployee.setFirst_europe_salary(employee.getFirst_europe_salary());
        germanEmployee.setId(employee.getId());
        germanEmployee.setLevel(employee.getLevel());
        germanEmployee.setNumber_of_job_in_europe(employee.getNumber_of_job_in_europe());
        germanEmployee.setPosition(employee.getPosition());
        germanEmployee.setSalary(employee.getSalary());
        germanEmployee.setSalary_1_year_ago(employee.getSalary_1_year_ago());
        germanEmployee.setSex(employee.getSex());
        germanEmployee.setTotal_experience(employee.getTotal_experience());
        germanEmployee.setWork_language(employee.getWork_language());
        entityManager.flush();
        logger.trace("Object {} has been updated successfully", () -> germanEmployee.getId());

    }

    @Override
    public void deleteEmployee(int employeeId) {
        entityManager.remove(getEmployeeById(employeeId));
    }

    @Override
    public int getLastId() { //used to update and delete tests
        String hql = "SELECT MAX(GE.id) FROM GermanEmployee as GE";
        return ((Number) entityManager.createQuery(hql).getSingleResult()).intValue();
    }
}
