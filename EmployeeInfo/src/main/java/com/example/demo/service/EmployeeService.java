package com.example.demo.service;

import java.util.List;

import com.example.demo.module.Employee;

public interface EmployeeService {

 public	Employee saveEmployee(Employee employee);
 
 List<Employee> getEmployees();
 
 Employee getEmployeeById(int id);
 
 Employee updateEmployeeById(int id,Employee employee);
 
 void deleteEmployeeById(int id);
}
