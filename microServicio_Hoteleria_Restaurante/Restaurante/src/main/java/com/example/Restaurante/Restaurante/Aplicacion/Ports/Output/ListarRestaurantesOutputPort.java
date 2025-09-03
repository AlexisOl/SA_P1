package com.example.Restaurante.Restaurante.Aplicacion.Ports.Output;

import com.example.Restaurante.Restaurante.Dominio.Restaurante;

import java.util.List;
import java.util.UUID;

public interface ListarRestaurantesOutputPort {
    List<Restaurante> listarRestaurantes();

}
