package com.Tecsup.examen.service;

import com.Tecsup.examen.model.PersonaEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonaService {
    PersonaEntity savePersona(PersonaEntity personaEntity);
    PersonaEntity obtenerPersonaPorId(Long id);
    List<PersonaEntity>obtenerTodasLasPersonas();
    PersonaEntity actualizarPersona(Long id,PersonaEntity personaEntity);
    void eliminarPersona(Long id);

}
