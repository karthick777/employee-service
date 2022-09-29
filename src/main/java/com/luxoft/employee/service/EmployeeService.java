package com.luxoft.employee.service;

import com.luxoft.employee.model.Employee;
import com.luxoft.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public void createEmployees() {
        for(int i=0;i<10;i++) {
            employeeRepository.save(new Employee("Test"+i,new Date()));
        }
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
