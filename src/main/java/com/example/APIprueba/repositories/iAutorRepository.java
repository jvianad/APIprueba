package com.example.APIprueba.repositories;

import com.example.APIprueba.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iAutorRepository extends BaseRepository<Autor, Long>{

}
