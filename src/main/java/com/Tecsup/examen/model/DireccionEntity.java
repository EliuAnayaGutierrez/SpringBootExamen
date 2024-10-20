package com.Tecsup.examen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DireccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="avenida",length=100)
    private String avenida;
    @Column(name="numero",length=10)
    private String numero;
    @Column(name="distrito",length=100)
    private String distrito;
    @Column(name="provincia",length=100)
    private String provincia;
    @Column(name="departamento",length=100)
    private String departamento;
}
