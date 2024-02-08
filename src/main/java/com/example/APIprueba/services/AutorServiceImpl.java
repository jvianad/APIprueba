package com.example.APIprueba.services;

import com.example.APIprueba.entities.Autor;
import com.example.APIprueba.repositories.BaseRepository;
import com.example.APIprueba.repositories.iAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService{
    @Autowired
    private iAutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }
}
