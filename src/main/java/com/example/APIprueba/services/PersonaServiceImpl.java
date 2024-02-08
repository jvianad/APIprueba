package com.example.APIprueba.services;
import com.example.APIprueba.entities.Persona;
import com.example.APIprueba.repositories.BaseRepository;
import com.example.APIprueba.repositories.iPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//si quiero un metodo especifico de persona
//debe ser aqui adentro, servicios especificos
@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {
    @Autowired
    private iPersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try{
            //List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro,filtro);
            //List<Persona> personas = personaRepository.search(filtro);
            List<Persona> personas = personaRepository.searchNative(filtro);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
