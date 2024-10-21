package com.Tecsup.examen.repository;

import com.Tecsup.examen.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepository extends JpaRepository<PedidoEntity,Long> {
}
