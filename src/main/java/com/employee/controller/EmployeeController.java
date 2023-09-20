package com.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.impl.EmployeeServiceImpl;


@RestController
@RequestMapping(path="api/employee")
public class EmployeeController extends GeneralControllerImpl<Employee, EmployeeServiceImpl> {
	
	@GetMapping("view")
	public ResponseEntity<?> listEmployeesView() throws Exception {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.listView());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Server error.\"}");
		}
	}
}
