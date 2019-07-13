package com.cassandra.poc.controller;

import com.cassandra.poc.model.Employee;
import com.cassandra.poc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("portal/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
        String id = String.valueOf(new Random().nextInt());
        Employee emp = new Employee(id, newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getEmail());
        employeeRepository.save(emp);
        return emp;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        Iterable<Employee> result = employeeRepository.findAll();
        List<Employee> employeesList = new ArrayList<Employee>();
        result.forEach(employeesList::add);
        return employeesList;
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable String id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        return emp;
    }
}