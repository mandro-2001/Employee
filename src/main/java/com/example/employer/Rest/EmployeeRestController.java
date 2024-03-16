package com.example.employer.Rest;

import com.example.employer.EmployeeDAO.EmployeesDAO;
import com.example.employer.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeesDAO EmployDAO;

    @Autowired
    public EmployeeRestController (EmployeesDAO EmployDAO){
        this.EmployDAO = EmployDAO;
    }

    @GetMapping("/employees")
    public List<Employee> allemployees()
    {
        List<Employee> allemploees = EmployDAO.findAll();
        return allemploees;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findemployee(@PathVariable int employeeId)
    {
        Employee getemploee = EmployDAO.findById(employeeId);
        return getemploee;
    }

    @Transactional
    @PostMapping("/employees")
    public Employee insertemployee(@RequestBody Employee employer){
        employer.setId(0);
        Employee postemployer = EmployDAO.save(employer);
        return postemployer;
    }

    @Transactional
    @PutMapping("/employees")
    public Employee editemployee(@RequestBody Employee employer) {
        Employee putemployer = EmployDAO.save(employer);
        return putemployer;
    }

    @Transactional
    @DeleteMapping("/employees/{employeeId}")
    public String deleteemployee (@PathVariable int employeeId){
        Employee tempemploy = EmployDAO.findById(employeeId);
        if(tempemploy == null){
            throw new RuntimeException("Employee id is not found");
        }
        EmployDAO.deleteid(employeeId);
        return "employee id got deleted ";

    }

}



