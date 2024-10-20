package com.Tecsup.examen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class PersonaEntity {
    @Id
    private Long nroDocumento;
    @Column(name="nombres",length = 100,nullable = false)
    private String nombres;
    @Column(name="apellidos",length = 100,nullable = false)
    private String apellidos;
    @Column(name="estado",nullable = false)
    private int estado;

    @Override
    public String toString() {
        return "PersonaEntity{" +
                "nroDocumento=" + nroDocumento +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", estado=" + estado +
                '}';
    }
}
