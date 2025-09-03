package com.example.Restaurante.Restaurante.Aplicacion.Ports.Input;

import com.example.Restaurante.Restaurante.Aplicacion.Service.CasoUsoCreacionRestaurante.CreacionRestauranteDTO;
import com.example.Restaurante.Restaurante.Dominio.Restaurante;

public interface CreacionRestauranteInputPort {

    Restaurante crearRestaurante(CreacionRestauranteDTO restaurante);
}
