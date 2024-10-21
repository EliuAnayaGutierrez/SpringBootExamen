package com.Tecsup.examen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String estado;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="persona_id",referencedColumnName = "id", nullable = false)
    private PersonaEntity persona;
}
