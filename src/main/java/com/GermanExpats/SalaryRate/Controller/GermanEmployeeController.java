package com.GermanExpats.SalaryRate.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.GermanExpats.SalaryRate.service.IGermanEmployeeService;
import com.GermanExpats.SalaryRate.entity.GermanEmployee;

@RestController
public class GermanEmployeeController {

    @Autowired
    private IGermanEmployeeService germanEmployeeService;

    @GetMapping("/germanemployee/{id}/")
    public ResponseEntity<GermanEmployee> getEmployeeById(@PathVariable("id") Integer id) {
        GermanEmployee germanEmployee = germanEmployeeService.getEmployeeById(id);
        return new ResponseEntity<GermanEmployee>(germanEmployee, HttpStatus.OK);
    }

    @GetMapping("/germanemployees/")
    public ResponseEntity<List<GermanEmployee>> getAllGermanEmployees() {

            List<GermanEmployee> list = germanEmployeeService.getAllEmployees();
        return new ResponseEntity<List<GermanEmployee>>(list, HttpStatus.OK);
    }

    @PostMapping("/germanemployee/")
    public ResponseEntity<Void> addEmployee(@RequestBody GermanEmployee germanEmployee, UriComponentsBuilder builder) {
        germanEmployeeService.addEmployee(germanEmployee);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/germanemployee/{id}").buildAndExpand(germanEmployee.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/germanemployee/")
    public ResponseEntity<GermanEmployee> updateGermanEmployee(@RequestBody GermanEmployee germanEmployee) {
        germanEmployeeService.updateEmployee(germanEmployee);
        return new ResponseEntity<GermanEmployee>(germanEmployee, HttpStatus.OK);
    }
    @DeleteMapping("/germanemployee/{id}/")
    public ResponseEntity<Void> deleteEmploye(@PathVariable("id") Integer id) {
        germanEmployeeService.deleteEmployee(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
