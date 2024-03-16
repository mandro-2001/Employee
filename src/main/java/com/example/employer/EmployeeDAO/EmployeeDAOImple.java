package com.example.employer.EmployeeDAO;

import com.example.employer.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImple implements EmployeesDAO{
    private EntityManager entitymanager;

    @Autowired
    public EmployeeDAOImple (EntityManager entitymanager){
        this.entitymanager = entitymanager;
    }
    @Override
    public List<Employee> findAll(){
        TypedQuery<Employee> display = entitymanager.createQuery("FROM Employee",Employee.class);
        List<Employee> displayemployee =  display.getResultList();
        return displayemployee;
    }

    @Override
    public Employee findById(Integer id){
        Employee employeeid = entitymanager.find(Employee.class , id);
        return employeeid;
    }

    @Override
    public Employee save(Employee employer)
    {
        Employee emplyer = entitymanager.merge(employer);
        return emplyer;
    }
    @Override
    public void deleteid (Integer id){
        Employee employer  = entitymanager.find(Employee.class , id);
        entitymanager.remove(employer);
    }
}
