package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.model.Base;
import com.employee.service.impl.GeneralServiceImpl;

public abstract class GeneralControllerImpl<T extends Base, S extends GeneralServiceImpl<T, Integer>> implements IGeneralController<T, Integer>{

	@Autowired
	protected S servicio;
	

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody T t){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(t));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\""+e+"\"}");
        }
    }
	
	@GetMapping("")
	public ResponseEntity<?> list() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.list());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error en servidor.\"}");
		}
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.listById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error en servidor.\"}");
        }
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody T t) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(t, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error en servidor.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error en servidor.\"}");
        }
    }
}
