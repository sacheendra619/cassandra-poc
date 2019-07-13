package com.cassandra.poc.repository;

import com.cassandra.poc.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,String> {

}