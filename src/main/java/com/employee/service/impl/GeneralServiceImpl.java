package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.employee.model.Base;
import com.employee.repository.IGeneralRepository;
import com.employee.service.IGeneralService;

public abstract class GeneralServiceImpl<T extends Base, ID> implements IGeneralService<T,ID> {

    protected IGeneralRepository<T, ID> getRepo;

    public GeneralServiceImpl(IGeneralRepository<T, ID> generalRepository) {
        this.getRepo = generalRepository;
    }
    @Override
    @Transactional
    public T save(T t) throws Exception{

        try {
            t = getRepo.save(t);
            return t;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public T update(T t, ID id)  throws Exception{
        try {
            Optional<T> entityOptional = getRepo.findById(id);
            T entityUpdate = entityOptional.get();
            entityUpdate = getRepo.save(t);
            return entityUpdate;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id)  throws Exception{
        try {
            if(getRepo.existsById(id)) {
                getRepo.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public T listById(ID id)  throws Exception{
        try {
            Optional<T> entityOptional = getRepo.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<T> list()  throws Exception{
        try {
            List<T> entities = getRepo.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
