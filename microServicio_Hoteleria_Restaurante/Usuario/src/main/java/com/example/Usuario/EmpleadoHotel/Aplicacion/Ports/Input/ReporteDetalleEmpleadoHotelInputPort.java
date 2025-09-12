package com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input;

import java.util.List;
import java.util.UUID;

public interface ReporteDetalleEmpleadoHotelInputPort {
    List<Object> detalleEmpleadoHotelReporteDTO(UUID id);
}
