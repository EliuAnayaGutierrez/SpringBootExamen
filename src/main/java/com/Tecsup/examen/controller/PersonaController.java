package com.Tecsup.examen.controller;

import com.Tecsup.examen.model.PersonaEntity;
import com.Tecsup.examen.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaRepository personaRepository;

    @PostMapping
    public ResponseEntity<PersonaEntity> crearPersona(@RequestBody PersonaEntity personaEntity){
    PersonaEntity nuevaPersona = personaRepository.savePersona(personaEntity);
        return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PersonaEntity>obtenerPersona(@PathVariable Long id){
        PersonaEntity persona = personaRepository.obtenerPersonaPorId(id);
        return new ResponseEntity<>(persona,HttpStatus.OK);
    }

    @GetMapping
    public List<PersonaEntity> obtenerTodosLosProductos(){
        return personaRepository.obtenerTodasLasPersonas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaEntity>actualizarPersona(@PathVariable Long id,@RequestBody
    PersonaEntity personaEntity){
        PersonaEntity personaActualizada = personaRepository.actualizarPersona(id,personaEntity);
        return new ResponseEntity<>(personaActualizada,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id){
        personaRepository.eliminarPersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
