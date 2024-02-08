package com.example.APIprueba.services;

import com.example.APIprueba.entities.Localidad;
import com.example.APIprueba.repositories.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad,Long> implements LocalidadService {

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }
}
