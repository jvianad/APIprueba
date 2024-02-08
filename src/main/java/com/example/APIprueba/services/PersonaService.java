package com.example.APIprueba.services;

import com.example.APIprueba.entities.Persona;

import java.util.List;

public interface PersonaService extends BaseService<Persona,Long>{
    List<Persona> search(String filtro) throws Exception;
}
