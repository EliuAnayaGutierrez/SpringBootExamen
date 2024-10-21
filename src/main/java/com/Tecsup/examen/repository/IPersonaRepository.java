package com.Tecsup.examen.repository;

import com.Tecsup.examen.model.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPersonaRepository extends JpaRepository<PersonaEntity,Long> {

}
