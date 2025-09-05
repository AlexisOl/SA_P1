package com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input;

import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;

import java.util.Optional;
import java.util.UUID;

public interface ListarEmpleadoEspecificoHotelInputPort {

    Optional<EmpleadoHotel> ListarEmpleadoEspecificoHotel(UUID id);
}
