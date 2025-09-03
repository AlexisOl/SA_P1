package com.example.Restaurante.Platillos.Aplicacion.Ports.Input;

import com.example.Restaurante.Platillos.Aplicacion.Service.CasoUsoCrearPlatillo.CrearPlatilloDTO;
import com.example.Restaurante.Platillos.Dominio.Platillos;

public interface CrearPlatilloInputPort {

    Platillos crearPlatillos(CrearPlatilloDTO crearPlatilloDTO);
}
