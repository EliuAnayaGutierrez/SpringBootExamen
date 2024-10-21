package com.Tecsup.examen.controller;

import com.Tecsup.examen.model.PedidoEntity;
import com.Tecsup.examen.model.PersonaEntity;
import com.Tecsup.examen.service.IPedidoService;
import com.Tecsup.examen.service.IPersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final IPedidoService pedidoService;


    public PedidoController(IPedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/addPedido")
    public ResponseEntity<PedidoEntity> crearPedido(@RequestBody PedidoEntity pedidoEntity){
        PedidoEntity nuevoPedido = pedidoService.savePedido(pedidoEntity);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PedidoEntity>obtenerPedido(@PathVariable Long id){
        PedidoEntity pedido = pedidoService.obtenerPedidoPorId(id);
        return new ResponseEntity<>(pedido,HttpStatus.OK);
    }

    @GetMapping
    public List<PedidoEntity> obtenerTodasLosPedidos(){
        return pedidoService.obtenerTodosLosPedidos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoEntity>actualizarPedido(@PathVariable Long id,@RequestBody
    PedidoEntity pedidoEntity){
        PedidoEntity pedidoActualizado = pedidoService.actualizarPedido(id,pedidoEntity);
        return new ResponseEntity<>(pedidoActualizado,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id){
        pedidoService.eliminarPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
