package com.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Position;
import com.employee.repository.IGeneralRepository;
import com.employee.repository.IPositionRepository;
import com.employee.service.IPositionService;

@Service
public class PositionServiceImpl  extends GeneralServiceImpl<Position, Integer> implements IPositionService{

	@Autowired
    private IPositionRepository employeeRepo;
	
	public PositionServiceImpl(IGeneralRepository<Position, Integer> generalRepository) {
		super(generalRepository);
	}

}
