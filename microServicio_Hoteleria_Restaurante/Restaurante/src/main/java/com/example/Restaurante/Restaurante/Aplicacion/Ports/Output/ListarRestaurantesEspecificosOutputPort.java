package com.example.Restaurante.Restaurante.Aplicacion.Ports.Output;

import com.example.Restaurante.Restaurante.Dominio.Restaurante;

import java.util.UUID;

public interface ListarRestaurantesEspecificosOutputPort {
    Restaurante listarRestaurantesEspecifico(UUID id);

}
