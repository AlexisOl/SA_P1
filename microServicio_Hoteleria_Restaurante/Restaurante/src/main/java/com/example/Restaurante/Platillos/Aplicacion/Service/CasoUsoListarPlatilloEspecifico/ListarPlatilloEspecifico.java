package com.example.Restaurante.Platillos.Aplicacion.Service.CasoUsoListarPlatilloEspecifico;

import com.example.Restaurante.Platillos.Aplicacion.Ports.Input.ListarPlatilloEspecificoInputPort;
import com.example.Restaurante.Platillos.Aplicacion.Ports.Output.ListarPlatilloEspecificoOutputPort;
import com.example.Restaurante.Platillos.Dominio.Platillos;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ListarPlatilloEspecifico implements ListarPlatilloEspecificoInputPort {
    private final ListarPlatilloEspecificoOutputPort listarPlatilloEspecificoOutputPort;


    public ListarPlatilloEspecifico(ListarPlatilloEspecificoOutputPort listarPlatilloEspecificoOutputPort){
        this.listarPlatilloEspecificoOutputPort =  listarPlatilloEspecificoOutputPort;
    }
    @Override
    public Optional<Platillos> listarPlatillos(UUID id) {
        return this.listarPlatilloEspecificoOutputPort.listarPlatillos(id);
    }
}
