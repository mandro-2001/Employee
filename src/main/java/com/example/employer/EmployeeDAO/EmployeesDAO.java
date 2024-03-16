package com.example.employer.EmployeeDAO;

import com.example.employer.entity.Employee;

import java.util.List;

public interface EmployeesDAO {
    public List<Employee> findAll();
    public Employee findById(Integer id);

    public Employee save(Employee theemployer);
    public void deleteid(Integer employeeId);
}
