package com.employee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.model.Base;

public interface IGeneralController <T extends Base, ID>{

	public ResponseEntity<?> list();
	public ResponseEntity<?> getOne(@PathVariable ID id);
	public ResponseEntity<?> update(@PathVariable ID id, @RequestBody T t);
	public ResponseEntity<?> save(@RequestBody T t);
	public ResponseEntity<?> delete(@PathVariable ID id);
}