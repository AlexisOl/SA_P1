package com.example.Restaurante.Platillos.Aplicacion.Ports.Output;

import com.example.Restaurante.Platillos.Dominio.Platillos;

import java.util.List;

public interface ListarPlatillosGlobalesOutputPort {
    List<Platillos> listarPlatillosGlobales();
}
