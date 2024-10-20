package com.Tecsup.examen.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="descripcion",length=100)
    private String descripcion;
    @Column(name="estado")
    private int estado;
}
