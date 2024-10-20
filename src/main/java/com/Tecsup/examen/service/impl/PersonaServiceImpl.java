package com.Tecsup.examen.service.impl;

import com.Tecsup.examen.model.PersonaEntity;
import com.Tecsup.examen.repository.IPersonaRepository;
import com.Tecsup.examen.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonaServiceImpl implements IPersonaService {


    private final IPersonaRepository personaRepository;

    public PersonaServiceImpl(IPersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public PersonaEntity savePersona(PersonaEntity personaEntity) {
        personaEntity.setEstado(1);
        return personaRepository.save(personaEntity);
    }

    @Override
    public PersonaEntity obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Cliente no Encontrado"));
    }

    @Override
    public List<PersonaEntity> obtenerTodasLasPersonas() {
        return personaRepository.findAllByEstado(1);
    }

    @Override
    public PersonaEntity actualizarPersona(Long id, PersonaEntity personaEntity) {
        PersonaEntity personaExistente=obtenerPersonaPorId(id);
        personaExistente.setNombres(personaEntity.getNombres());
        personaExistente.setApellidos(personaEntity.getApellidos());
        return personaRepository.save(personaExistente);
    }

    @Override
    public void eliminarPersona(Long id) {
        PersonaEntity personaExistente=obtenerPersonaPorId(id);
        personaExistente.setEstado(0);
        personaRepository.save(personaExistente);
    }
}
