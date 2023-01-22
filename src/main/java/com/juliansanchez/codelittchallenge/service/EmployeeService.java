package com.juliansanchez.codelittchallenge.service;

import com.juliansanchez.codelittchallenge.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeService employeeService;

    public EmployeeService(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    public Optional<Employee> findById() {
        return Optional.empty();
    }
}
