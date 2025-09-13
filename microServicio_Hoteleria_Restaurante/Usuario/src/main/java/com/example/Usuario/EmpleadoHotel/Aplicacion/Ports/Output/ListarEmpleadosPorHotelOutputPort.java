package com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output;

import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;

import java.util.List;

public interface ListarEmpleadosPorHotelOutputPort {
    List<EmpleadoHotel> listarEmpleadosPorHotel(Long id);

}
