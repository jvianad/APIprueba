package com.example.APIprueba.repositories;

import com.example.APIprueba.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//clase generica que da metodos para acceder a metodods de BD
//tmbn querys ya armadas

@Repository
public interface iPersonaRepository extends BaseRepository<Persona, Long> {
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    @Query(value = "select p from Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param(value = "filtro") String filtro);

    @Query(value = "select p from Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> search(@Param(value = "filtro") String filtro, Pageable pageable);

    @Query(value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
    nativeQuery = true)
    List<Persona> searchNative(String filtro);

    @Query(value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true)
    Page<Persona> searchNative(String filtro, Pageable pageable);
}
