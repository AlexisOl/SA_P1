package com.example.Restaurante.Platillos.Aplicacion.Ports.Output;

import com.example.Restaurante.Platillos.Dominio.Platillos;

import java.util.UUID;

public interface ListarPlatilloEspecificoOutputPort {
    Platillos listarPlatillosEspecificos(UUID id);
}
