package com.example.APIprueba.services;
import com.example.APIprueba.entities.Persona;
import com.example.APIprueba.repositories.iPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements BaseService<Persona>{
    @Autowired
    private iPersonaRepository personaRepository;

    @Override
    @Transactional//van a ser transacciones con la BD
    public List<Persona> findAll() throws Exception {
        try{
            List<Persona> entities = personaRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional//van a ser transacciones con la BD
    public Persona findById(Long id) throws Exception {
        try{
            Optional<Persona> entityOptional = personaRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional//van a ser transacciones con la BD
    public Persona save(Persona entity) throws Exception {
        try{
            entity = personaRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional//van a ser transacciones con la BD
    public boolean delete(Long id) throws Exception {
        try{
            if (personaRepository.existsById(id)){
                personaRepository.deleteById(id);
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
    public Persona update(Long id, Persona entity) throws Exception {
        try{
            Optional<Persona> entityOptional = personaRepository.findById(id);
            Persona persona = entityOptional.get();
            persona = personaRepository.save(persona);
            return persona;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional//van a ser transacciones con la BD
    public Persona refreshUser(Long id, Persona entity) throws Exception {
        try{
            Optional<Persona> entityOptional = personaRepository.findById(id);
            Persona person = entityOptional.get();

            person.setNombre(entity.getNombre());
            person.setApellido(entity.getApellido());
            person.setDni(entity.getDni());
            personaRepository.save(person);
            return person;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
