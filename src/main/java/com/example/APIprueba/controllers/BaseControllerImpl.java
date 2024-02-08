package com.example.APIprueba.controllers;

import com.example.APIprueba.entities.Base;
import com.example.APIprueba.entities.Persona;
import com.example.APIprueba.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E,Long>> implements BaseController<E, Long> {

    @Autowired
    protected S servicio;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No encontrar nada\"}");
        }
    }

    @GetMapping("/{id}")
    //pathvariable es uan variable q esta dentro de la
    // url por la cual accedemos al recurso
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(servicio.save(entity));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"usuario con ese id no existe\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody E entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id,entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"usuario con ese id no existe\"}");
        }
    }
}
