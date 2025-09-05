package com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output;

import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;

import java.util.Optional;
import java.util.UUID;

public interface ListarEmpleadoEspecificoHotelOutputPort {
    Optional<EmpleadoHotel> ListarEmpleadoEspecificoHotel(UUID id);

}
