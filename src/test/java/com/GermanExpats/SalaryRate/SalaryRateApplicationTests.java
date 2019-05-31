package com.GermanExpats.SalaryRate;

import com.GermanExpats.SalaryRate.service.GermanEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.web.client.RestTemplate;
import com.GermanExpats.SalaryRate.entity.GermanEmployee;
import com.GermanExpats.SalaryRate.DAO.GermanEmployeeDAO;
import com.GermanExpats.SalaryRate.service.IGermanEmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.GermanExpats.SalaryRate.Controller.GermanEmployeeController;

import java.net.URI;

/**
 * Test methods for all application functionality
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SalaryRateApplicationTests {

    private int lastId;

    @Autowired
    IGermanEmployeeService germanEmployeeService;

    @Autowired
    private GermanEmployeeController controller;

    /**
     * Logger has default properties. Log out to console.
     */
    private static final Logger logger = LogManager.getLogger(SalaryRateApplicationTests.class);



    @Test
    public void getEmployeeByIdDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/germanemployee/{id}/";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<GermanEmployee> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, GermanEmployee.class, 1);
        GermanEmployee germanEmployee = responseEntity.getBody();
        System.out.println("Id:"+germanEmployee.getId()+", Position:"+germanEmployee.getPosition());
    }

    @Test
    public void getAllEmployeesDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/germanemployees/";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<GermanEmployee[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, GermanEmployee[].class);
        GermanEmployee[] germanEmployees = responseEntity.getBody();
        for (GermanEmployee germanEmployee : germanEmployees) {
            System.out.println("Id:" + germanEmployee.getId() +
                    ", Position:" + germanEmployee.getPosition());

        }
    }

    @Test
    public void test1AddEmployeeDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/germanemployee/";
        GermanEmployee objEmployee = new GermanEmployee();
        objEmployee.setDate_point("12/13/2016 14:11");
        objEmployee.setTotal_experience(1);
        objEmployee.setSex('m');
        objEmployee.setWork_language("Test");
        objEmployee.setSalary_1_year_ago(111);
        objEmployee.setSalary(111);
        objEmployee.setPosition("Test");
        objEmployee.setNumber_of_job_in_europe(1);
        objEmployee.setLevel("Test");
        objEmployee.setFirst_europe_salary(111);
        objEmployee.setExperience_in_Europe(1);
        objEmployee.setCompany_type("Test");
        objEmployee.setCompany_size("Test");
        objEmployee.setCity("Test");
        objEmployee.setAge(1);
        HttpEntity<GermanEmployee> requestEntity = new HttpEntity<GermanEmployee>(objEmployee, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());
        //lambda allows don't check is required log level enabled
        logger.info("Test object id: {} has been created successfully", () -> germanEmployeeService.getLastId());


    }

    @Test
    public void test2UpdateEmployeeDemo() {
        lastId = germanEmployeeService.getLastId();
        System.out.println("lastId: " + lastId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/germanemployee/";
        GermanEmployee objEmployee = new GermanEmployee();
        objEmployee.setId(lastId);
        objEmployee.setDate_point("12/13/2016 14:11");
        objEmployee.setTotal_experience(1);
        objEmployee.setSex('m');
        objEmployee.setWork_language("TestUpdate");
        objEmployee.setSalary_1_year_ago(111);
        objEmployee.setSalary(111);
        objEmployee.setPosition("TestUpdate");
        objEmployee.setNumber_of_job_in_europe(1);
        objEmployee.setLevel("TestUpdate");
        objEmployee.setFirst_europe_salary(111);
        objEmployee.setExperience_in_Europe(1);
        objEmployee.setCompany_type("TestUpdate");
        objEmployee.setCompany_size("TestUpdate");
        objEmployee.setCity("TestUpdate");
        objEmployee.setAge(1);
        HttpEntity<GermanEmployee> requestEntity = new HttpEntity<GermanEmployee>(objEmployee, headers);
        restTemplate.put(url, requestEntity);
        //lambda allows don't check is required log level enabled
        logger.info("Test object id: {} has been updated successfully", () -> objEmployee.getId());
    }
    @Test
    public void test3DeleteEmployeeDemo() {
        lastId = germanEmployeeService.getLastId(); //will delete object with last id in DB
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/germanemployee/".concat(String.valueOf(lastId).concat("/"));
        HttpEntity<GermanEmployee> requestEntity = new HttpEntity<GermanEmployee>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
        //lambda allows don't check is required log level enabled
        logger.info("Test object id: {} has been deleted successfully", () -> lastId);

    }


    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    public static void main(String args[]) {
        SalaryRateApplicationTests util = new SalaryRateApplicationTests();
        util.getAllEmployeesDemo();
        util.getEmployeeByIdDemo();
        util.test1AddEmployeeDemo();
        util.test2UpdateEmployeeDemo();
        util.test3DeleteEmployeeDemo();


    }

}

