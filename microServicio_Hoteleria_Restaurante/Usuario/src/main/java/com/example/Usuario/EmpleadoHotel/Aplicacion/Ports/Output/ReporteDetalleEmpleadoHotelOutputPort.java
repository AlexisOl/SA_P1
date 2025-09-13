package com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output;

import java.util.List;
import java.util.UUID;

public interface ReporteDetalleEmpleadoHotelOutputPort {
    List<Object> detalleEmpleadoHotelReporteDTO(UUID id);

}
