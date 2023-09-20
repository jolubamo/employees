package com.employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.impl.EmployeeServiceImpl;


@RestController
@RequestMapping(path="api/employee")
public class EmployeeController extends GeneralControllerImpl<Employee, EmployeeServiceImpl> {
}
