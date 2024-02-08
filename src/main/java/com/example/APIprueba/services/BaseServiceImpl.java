package com.example.APIprueba.services;

import com.example.APIprueba.entities.Base;
import com.example.APIprueba.repositories.BaseRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E,ID> {
    protected BaseRepository<E,ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional//van a ser transacciones con la BD
    public List<E> findAll() throws Exception {
        try{
            List<E> entities = baseRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional//van a ser transacciones con la BD
    public E findById(ID id) throws Exception {
        try{
            Optional<E> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional//van a ser transacciones con la BD
    public E save(E entity) throws Exception {
        try{
            entity = baseRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional//van a ser transacciones con la BD
    public boolean delete(ID id) throws Exception {
        try{
            if (baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional//van a ser transacciones con la BD
    public E update(ID id, E entity) throws Exception {
        try{
            Optional<E> entityOptional = baseRepository.findById(id);
            E entityUpdate = entityOptional.get();
            entityUpdate = baseRepository.save(entity);
            return entityUpdate;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
