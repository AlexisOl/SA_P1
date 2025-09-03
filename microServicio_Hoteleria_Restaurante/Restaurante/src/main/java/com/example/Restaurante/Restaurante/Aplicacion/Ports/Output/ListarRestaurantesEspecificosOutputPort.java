package com.example.Restaurante.Restaurante.Aplicacion.Ports.Output;

import com.example.Restaurante.Restaurante.Dominio.Restaurante;

import java.util.Optional;
import java.util.UUID;

public interface ListarRestaurantesEspecificosOutputPort {
    Optional<Restaurante> listarRestaurantesEspecifico(UUID id);

}
