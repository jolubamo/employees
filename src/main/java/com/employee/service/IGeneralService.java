package com.employee.service;

import java.util.List;

import com.employee.model.Base;

public interface IGeneralService<T extends Base, ID> {
    List<T> list() throws Exception;

    T save(T t) throws Exception;

    T update(T t, ID id) throws Exception;

    boolean delete(ID id) throws Exception;

    T listById(ID id) throws Exception;
}
