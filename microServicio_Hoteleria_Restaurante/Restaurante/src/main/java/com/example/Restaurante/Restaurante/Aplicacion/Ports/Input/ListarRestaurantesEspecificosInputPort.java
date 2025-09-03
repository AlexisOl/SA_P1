package com.example.Restaurante.Restaurante.Aplicacion.Ports.Input;

import com.example.Restaurante.Restaurante.Dominio.Restaurante;

import java.rmi.server.UID;
import java.util.UUID;

public interface ListarRestaurantesEspecificosInputPort {

    Restaurante listarRestauranteEspecifico(UUID id);
}
