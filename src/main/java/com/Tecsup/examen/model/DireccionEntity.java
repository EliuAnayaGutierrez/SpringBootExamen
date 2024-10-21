package com.Tecsup.examen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "direccion")
public class DireccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String avenida;

    /*private String numero;

    private String distrito;

    private String provincia;
    private String departamento;*/

    @OneToOne
    @JoinColumn(name = "persona_id",referencedColumnName = "id")
    private PersonaEntity persona;
}
