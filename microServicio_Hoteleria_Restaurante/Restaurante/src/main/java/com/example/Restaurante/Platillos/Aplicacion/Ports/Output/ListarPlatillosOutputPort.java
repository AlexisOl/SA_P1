package com.example.Restaurante.Platillos.Aplicacion.Ports.Output;

import com.example.Restaurante.Platillos.Dominio.Platillos;

import java.util.List;
import java.util.UUID;

public interface ListarPlatillosOutputPort {
    List<Platillos> listarPlatillos(UUID id);
}
