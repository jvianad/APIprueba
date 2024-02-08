package com.example.APIprueba.controllers;

import com.example.APIprueba.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

//signo de pregunta response entity ? recibe cualquier tipo
//que extiende de object

public interface BaseController<E extends Base,ID extends Serializable>{
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody E entity);
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);
    public ResponseEntity<?> delete(@PathVariable ID id);
}
