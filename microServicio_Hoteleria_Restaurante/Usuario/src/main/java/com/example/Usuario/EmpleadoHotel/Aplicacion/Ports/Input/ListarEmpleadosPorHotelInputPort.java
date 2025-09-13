package com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input;

import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;

import java.util.List;

public interface ListarEmpleadosPorHotelInputPort {

    List<EmpleadoHotel> listarEmpleadosPorHotel(Long id);
}
