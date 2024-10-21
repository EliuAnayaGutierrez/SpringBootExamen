package com.Tecsup.examen.service.impl;

import com.Tecsup.examen.model.PedidoEntity;
import com.Tecsup.examen.repository.IPedidoRepository;
import com.Tecsup.examen.service.IPedidoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PedidoServiceImpl implements IPedidoService {

    private final IPedidoRepository pedidoRepository;

    public PedidoServiceImpl(IPedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }


    @Override
    public PedidoEntity savePedido(PedidoEntity pedidoEntity) {
        pedidoEntity.setEstado("Pendiente");
        return pedidoRepository.save(pedidoEntity);
    }

    @Override
    public PedidoEntity obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElseThrow(()->
                new NoSuchElementException("Pedido no encontrado"));
    }

    @Override
    public List<PedidoEntity> obtenerTodosLosPedidos() {

        return pedidoRepository.findAll();
    }

    @Override
    public PedidoEntity actualizarPedido(Long id, PedidoEntity pedidoEntity) {
        PedidoEntity pedidoExistente = obtenerPedidoPorId(id);
        pedidoExistente.setDescripcion(pedidoEntity.getDescripcion());
        pedidoExistente.setPersona(pedidoEntity.getPersona());
        pedidoExistente.setEstado(pedidoEntity.getEstado());
        return pedidoRepository.save(pedidoExistente);
    }

    @Override
    public void eliminarPedido(Long id) {
        PedidoEntity pedidoExistente = obtenerPedidoPorId(id);
        pedidoExistente.setEstado("Eliminado");
    }

}
