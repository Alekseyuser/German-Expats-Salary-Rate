package com.GermanExpats.SalaryRate.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.GermanExpats.SalaryRate.service.IGermanEmployeeService;
import com.GermanExpats.SalaryRate.entity.GermanEmployee;
import org.springframework.ui.Model;


@Controller
public class GermanEmployeeController {

    @Autowired
    private IGermanEmployeeService germanEmployeeService;

    @GetMapping("/")
    public String showPage(Model model, @RequestParam(defaultValue="0") int page){
        model.addAttribute("data", germanEmployeeService.getAllEmployees(page));
        model.addAttribute("currentPage", page);
        return "index";
    }

    @GetMapping("/germanemployee/{id}/")
    @ResponseBody
    public ResponseEntity<GermanEmployee> getEmployeeById(@PathVariable("id") Integer id) {
        GermanEmployee germanEmployee = germanEmployeeService.getEmployeeById(id);
        return new ResponseEntity<GermanEmployee>(germanEmployee, HttpStatus.OK);
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
