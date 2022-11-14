package com.bright.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bright.springboot.exception.ResourceNotFoundException;
import com.bright.springboot.model.Employee;
import com.bright.springboot.repository.EmployeeRepository;


@Service
public class EmployeeService {

    
    private EmployeeRepository employeeRepository; 


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(() -> 
        new ResourceNotFoundException("Employee", "id", id));
    }

    public Employee updateEmployee(Employee employee, Long id){
        //Check if the employee with id exists in the database

        Employee existingEmployee = employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    public void deleteEmployeeById(Long id){
        //Check if the employee with id exists in the database

        employeeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    
    }
}

