package com.Tecsup.examen.repository;

import com.Tecsup.examen.model.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPersonaRepository extends JpaRepository<PersonaEntity,Long> {
    List<PersonaEntity> findAllByEstado(int estado);
    PersonaEntity savePersona(PersonaEntity personaEntity);
    PersonaEntity obtenerPersonaPorId(Long id);
    List<PersonaEntity>obtenerTodasLasPersonas();
    PersonaEntity actualizarPersona(Long id,PersonaEntity personaEntity);
    void eliminarPersona(Long id);
}
