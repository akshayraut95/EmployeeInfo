package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.module.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
