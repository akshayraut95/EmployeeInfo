package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.module.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public Employee updateEmployeeById(int id, Employee employee) {
		// TODO Auto-generated method stub
		Employee updateemployee=employeeRepository.findById(id).orElse(null);
		if(updateemployee!=null)
		{
			updateemployee.setFirstname(employee.getFirstname());
			updateemployee.setLastname(employee.getLastname());
			updateemployee.setEmail(employee.getEmail());
			updateemployee.setPhone(employee.getPhone());
			updateemployee.setAddress(employee.getAddress());
			
			employeeRepository.save(updateemployee);
		}
		return updateemployee;
	}

	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		
		employeeRepository.deleteById(id);
		
	}

	@Override
	public String getEmployeeNameById(int id) {
		Employee emp=employeeRepository.findById(id).orElseThrow();
		return emp.getFirstname()+" "+emp.getLastname();
	}

}
