package com.example.Restaurante.Platillos.Aplicacion.Ports.Input;

import com.example.Restaurante.Platillos.Dominio.Platillos;

import java.util.List;

public interface ListarPlatillosGlobalesInputPort {
    List<Platillos> listarPlatillosGlobales();
}
