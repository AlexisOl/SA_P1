package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output;

import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;
import com.example.Usuario.Persona.Dominio.Persona;

import java.util.UUID;

public interface EmpleadoRestaurantePorCuiOutputPort {

    EmpleadoRestaurante obtenerEmpleaado(Persona persona);
}
