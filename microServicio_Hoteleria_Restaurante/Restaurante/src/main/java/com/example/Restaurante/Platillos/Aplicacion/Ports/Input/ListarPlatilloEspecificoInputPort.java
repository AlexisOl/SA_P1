package com.example.Restaurante.Platillos.Aplicacion.Ports.Input;

import com.example.Restaurante.Platillos.Dominio.Platillos;

import java.util.Optional;
import java.util.UUID;

public interface ListarPlatilloEspecificoInputPort {

    Optional<Platillos> listarPlatillos(UUID id);
}
