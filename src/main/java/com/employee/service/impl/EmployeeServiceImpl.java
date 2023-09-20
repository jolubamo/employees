package com.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.IEmployeeRepository;
import com.employee.repository.IGeneralRepository;
import com.employee.service.IEmployeeService;

@Service
public class EmployeeServiceImpl extends GeneralServiceImpl<Employee, Integer> implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepo;

    public EmployeeServiceImpl(IGeneralRepository<Employee, Integer> generalRepository) {
        super(generalRepository);
    }
}
