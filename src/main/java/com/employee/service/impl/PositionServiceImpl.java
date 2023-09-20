package com.employee.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.model.Position;
import com.employee.repository.IEmployeeRepository;
import com.employee.repository.IGeneralRepository;
import com.employee.repository.IPositionRepository;
import com.employee.service.IPositionService;

@Service
public class PositionServiceImpl  extends GeneralServiceImpl<Position, Integer> implements IPositionService{

	@Autowired
    private IPositionRepository positionRepo;
	
	@Autowired
    private IEmployeeRepository employeeRepo;
	
	public PositionServiceImpl(IGeneralRepository<Position, Integer> generalRepository) {
		super(generalRepository);
	}
	
	@Override
	public Position save(Position t) throws Exception {
		
		Employee employee = employeeRepo.save(t.getEmployee());
		
		t.setEmployee(employee);
		
		return super.save(t);
	}
	
	@Override
	public Position update(Position t, Integer id) throws Exception {
		
		try {
            employeeRepo.save(t.getEmployee());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
		
		return super.update(t, id);
		
	}

}
