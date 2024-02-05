package com.example.APIprueba.repositories;

import com.example.APIprueba.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//clase generica que da metodos para acceder a metodods de BD
//tmbn querys ya armadas

@Repository
public interface iPersonaRepository extends JpaRepository<Persona, Long> {

}
