package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.employee.model.Base;

@NoRepositoryBean
public interface IGeneralRepository<T extends Base,ID> extends JpaRepository<T, ID> {

}