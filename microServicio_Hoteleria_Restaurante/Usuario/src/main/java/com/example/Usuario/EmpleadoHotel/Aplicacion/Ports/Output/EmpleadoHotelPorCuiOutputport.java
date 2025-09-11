package com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output;

import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output.EmpleadoRestaurantePorCuiOutputPort;
import com.example.Usuario.Persona.Dominio.Persona;

public interface EmpleadoHotelPorCuiOutputport {
    EmpleadoHotel obtenerEmpleaado(Persona persona);

}
