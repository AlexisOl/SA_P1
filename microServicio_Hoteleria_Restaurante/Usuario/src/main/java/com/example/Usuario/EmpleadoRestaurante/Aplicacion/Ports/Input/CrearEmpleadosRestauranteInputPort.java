package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Input;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Service.CrearEmpleadoHotel.CrearEmpleadoDTO;
import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Service.CrearEmpleadoRestaurante.CrearEmpleadoRestauranteDTO;
import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;

public interface CrearEmpleadosRestauranteInputPort
{
    EmpleadoRestaurante crearEmpleadosHRestaurante(CrearEmpleadoRestauranteDTO crearEmpleadoRestauranteDTO);

}
