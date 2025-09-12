package com.example.Restaurante.Platillos.Aplicacion.Service.CasoUsoListarPlatilloEspecifico;

import com.example.Restaurante.Platillos.Aplicacion.Factory.PlatillosFactory;
import com.example.Restaurante.Platillos.Aplicacion.Ports.Input.ListarPlatilloEspecificoInputPort;
import com.example.Restaurante.Platillos.Aplicacion.Ports.Output.ListarPlatilloEspecificoOutputPort;
import com.example.Restaurante.Platillos.Dominio.Platillos;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ListarPlatilloEspecifico implements ListarPlatilloEspecificoInputPort {
    private final ListarPlatilloEspecificoOutputPort listarPlatilloEspecificoOutputPort;
    private final PlatillosFactory platillosFactory;

    public ListarPlatilloEspecifico(ListarPlatilloEspecificoOutputPort listarPlatilloEspecificoOutputPort,
                                    PlatillosFactory platillosFactory){
        this.listarPlatilloEspecificoOutputPort =  listarPlatilloEspecificoOutputPort;
        this.platillosFactory = platillosFactory;
    }
    @Override
    public Optional<Platillos> listarPlatillosEspecifico(UUID id) {
        return Optional.ofNullable(this.platillosFactory.createPlatilloConPuntuacion(this.listarPlatilloEspecificoOutputPort.listarPlatillosEspecificos(id)));
    }
}
