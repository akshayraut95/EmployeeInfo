package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Employee;
import com.example.demo.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

      @PostMapping("/save")
      public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
    
    	  Employee emp=employeeService.saveEmployee(employee);
      return ResponseEntity.ok().body(emp);
     }

       @GetMapping("/employeeslist")
       public List<Employee> getEmployees() {
       return employeeService.getEmployees();
       }

       @GetMapping("/{id}")
       public Employee getEmployeeById(@PathVariable int id) {
           
    	   return employeeService.getEmployeeById(id); 
       }
       
       
      @PutMapping("/{id}")
      public Employee updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
          //TODO: process PUT request
          
          return employeeService.updateEmployeeById(id, employee);
      }
      
      
      @DeleteMapping("/{id}")
  	public void deleteEmployeeById(@PathVariable int id) {
    	  
  		 employeeService.deleteEmployeeById(id);
  		 
  		 System.out.println("Deleted Succefully...");
      }
  		

  		@GetMapping("/{id}/fullname")
  	    public ResponseEntity<String> getEmployeeFullName(@PathVariable int id) {
  	        String fullName = employeeService.getEmployeeNameById(id);
  	        return ResponseEntity.ok(fullName);
  		
  	
}
}