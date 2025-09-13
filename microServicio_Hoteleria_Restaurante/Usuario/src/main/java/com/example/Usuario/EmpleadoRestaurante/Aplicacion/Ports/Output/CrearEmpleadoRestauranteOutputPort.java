package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output;

import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Service.CrearEmpleadoRestaurante.CrearEmpleadoRestauranteDTO;
import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;

public interface CrearEmpleadoRestauranteOutputPort {

    EmpleadoRestaurante crearEmpleadosHRestaurante(EmpleadoRestaurante empleadoRestaurante);

}
