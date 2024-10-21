package com.Tecsup.examen.controller;

import com.Tecsup.examen.model.PersonaEntity;
import com.Tecsup.examen.repository.IPersonaRepository;
import com.Tecsup.examen.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final IPersonaService personaService;

    public PersonaController(IPersonaService personaService) {
        this.personaService = personaService;
    }


    @PostMapping
    public ResponseEntity<PersonaEntity> crearPersona(@RequestBody PersonaEntity personaEntity){
    PersonaEntity nuevaPersona = personaService.savePersona(personaEntity);
        return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PersonaEntity>obtenerPersona(@PathVariable Long id){
        PersonaEntity persona = personaService.obtenerPersonaPorId(id);
        return new ResponseEntity<>(persona,HttpStatus.OK);
    }

    @GetMapping
    public List<PersonaEntity> obtenerTodasLasPersonas(){
        return personaService.obtenerTodasLasPersonas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaEntity>actualizarPersona(@PathVariable Long id,@RequestBody
    PersonaEntity personaEntity){
        PersonaEntity personaActualizada = personaService.actualizarPersona(id,personaEntity);
        return new ResponseEntity<>(personaActualizada,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id){
        personaService.eliminarPersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
