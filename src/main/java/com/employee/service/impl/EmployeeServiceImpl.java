package com.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.model.EmployeeView;
import com.employee.repository.IEmployeeRepository;
import com.employee.repository.IEmployeeViewRepository;
import com.employee.repository.IGeneralRepository;
import com.employee.service.IEmployeeService;

@Service
public class EmployeeServiceImpl extends GeneralServiceImpl<Employee, Integer> implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepo;
    
    @Autowired
    private IEmployeeViewRepository viewRepo;

    public EmployeeServiceImpl(IGeneralRepository<Employee, Integer> generalRepository) {
        super(generalRepository);
    }

	@Override
	public List<EmployeeView> listView() throws Exception {
		// TODO Auto-generated method stub
		return viewRepo.findAll();
	}
}
