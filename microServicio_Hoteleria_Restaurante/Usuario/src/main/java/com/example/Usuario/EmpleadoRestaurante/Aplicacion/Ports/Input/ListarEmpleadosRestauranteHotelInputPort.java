package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Input;

import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;

import java.util.List;
import java.util.UUID;

//empleados por restaurante
public interface ListarEmpleadosRestauranteHotelInputPort {

    List<EmpleadoRestaurante> listarEmpleadosPorRestaurante(UUID id);
}
