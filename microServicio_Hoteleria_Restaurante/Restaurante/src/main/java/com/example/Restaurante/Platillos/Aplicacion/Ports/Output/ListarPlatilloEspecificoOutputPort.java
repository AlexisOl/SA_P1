package com.example.Restaurante.Platillos.Aplicacion.Ports.Output;

import com.example.Restaurante.Platillos.Dominio.Platillos;

import java.util.Optional;
import java.util.UUID;

public interface ListarPlatilloEspecificoOutputPort {
    Optional<Platillos> listarPlatillosEspecificos(UUID id);
}
