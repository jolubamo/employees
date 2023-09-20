package com.employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Position;
import com.employee.service.impl.PositionServiceImpl;

@RestController
@RequestMapping(path="api/position")
public class PositionController  extends GeneralControllerImpl<Position, PositionServiceImpl>{

}
