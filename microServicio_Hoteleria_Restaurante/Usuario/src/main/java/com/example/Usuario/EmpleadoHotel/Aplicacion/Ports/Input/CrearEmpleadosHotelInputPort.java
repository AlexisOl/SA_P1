package com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Service.CrearEmpleadoHotel.CrearEmpleadoDTO;
import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;

public interface CrearEmpleadosHotelInputPort
{

    EmpleadoHotel crearEmpleadosHotel(CrearEmpleadoDTO empleado);
}
