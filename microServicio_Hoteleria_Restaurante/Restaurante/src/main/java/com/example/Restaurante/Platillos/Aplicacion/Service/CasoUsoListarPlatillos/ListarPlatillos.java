package com.example.Restaurante.Platillos.Aplicacion.Service.CasoUsoListarPlatillos;

import com.example.Restaurante.Platillos.Aplicacion.Factory.PlatillosFactory;
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
    private final PlatillosFactory platillosFactory;


    public ListarPlatillos(ListarPlatillosOutputPort listarPlatillosOutputPort,
                           PlatillosFactory platillosFactory){
        this.listarPlatillosOutputPort =  listarPlatillosOutputPort;
        this.platillosFactory = platillosFactory;

    }
    @Override
    public List<Platillos> listarPlatillos(UUID id) {
        return this.listarPlatillosOutputPort.listarPlatillos(id)
                .stream()
                .map(
                        platillos ->  platillosFactory.createPlatilloConPuntuacion(platillos)
                ).toList();
    }
}
