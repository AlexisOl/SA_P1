package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output;

import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;

import java.util.List;
import java.util.UUID;

public interface ListarEmpleadosRestaurantePorRestauranteOutPutPort {
    List<EmpleadoRestaurante> listarEmpleadosPorRestaurante(UUID id);

}
