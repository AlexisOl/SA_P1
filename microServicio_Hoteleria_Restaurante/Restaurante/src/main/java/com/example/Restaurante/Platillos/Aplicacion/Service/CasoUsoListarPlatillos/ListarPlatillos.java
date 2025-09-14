package com.example.Restaurante.Platillos.Aplicacion.Service.CasoUsoListarPlatillos;

import com.example.Restaurante.Platillos.Aplicacion.Ports.Input.ListarPlatillosInputPort;
import com.example.Restaurante.Platillos.Aplicacion.Ports.Output.ListarPlatilloEspecificoOutputPort;
import com.example.Restaurante.Platillos.Aplicacion.Ports.Output.ListarPlatillosOutputPort;
import com.example.Restaurante.Platillos.Dominio.Platillos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListarPlatillos implements ListarPlatillosInputPort {
    private final ListarPlatillosOutputPort listarPlatillosOutputPort;


    public ListarPlatillos(ListarPlatillosOutputPort listarPlatillosOutputPort){
        this.listarPlatillosOutputPort =  listarPlatillosOutputPort;
    }
    @Override
    public List<Platillos> listarPlatillos(UUID id) {
        return this.listarPlatillosOutputPort.listarPlatillos(id);
    }
}
