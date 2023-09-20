package com.employee.service;

import java.util.List;

import com.employee.model.Employee;
import com.employee.model.EmployeeView;

public interface IEmployeeService extends IGeneralService<Employee, Integer>{
	
	List<EmployeeView> listView() throws Exception;
}
