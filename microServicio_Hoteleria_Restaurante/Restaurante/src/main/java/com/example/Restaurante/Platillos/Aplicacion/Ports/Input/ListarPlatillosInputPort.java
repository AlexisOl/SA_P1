package com.example.Restaurante.Platillos.Aplicacion.Ports.Input;

import com.example.Restaurante.Platillos.Dominio.Platillos;

import java.util.List;
import java.util.UUID;

public interface ListarPlatillosInputPort {
    List<Platillos> listarPlatillos(UUID id);
}
