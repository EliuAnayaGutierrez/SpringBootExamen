package com.Tecsup.examen.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="persona")
@Setter
@Getter
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long nroDocumento;

    private String nombres;

    private String apellidos;

    private String estado;


    @OneToOne(cascade = {CascadeType.ALL,CascadeType.MERGE})
    @JoinColumn(name="direccion_id",referencedColumnName="id")
    private DireccionEntity direccionEntity;

    @JsonManagedReference
    @OneToMany
    private List<PedidoEntity>pedidos;


    @Override
    public String toString() {
        return "PersonaEntity{" +
                "nroDocumento=" + nroDocumento +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", estado=" + estado +
                ", direccionEntity=" + direccionEntity +
                '}';
    }
}
