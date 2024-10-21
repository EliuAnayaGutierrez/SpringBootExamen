package com.Tecsup.examen.service;

import com.Tecsup.examen.model.PedidoEntity;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface IPedidoService {
    PedidoEntity savePedido(PedidoEntity pedidoEntity);
    PedidoEntity obtenerPedidoPorId(Long id);
    List<PedidoEntity> obtenerTodosLosPedidos();
    PedidoEntity actualizarPedido(Long id,PedidoEntity pedidoEntity);
    void eliminarPedido(Long id);
}
