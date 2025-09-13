package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output;

import java.util.List;
import java.util.UUID;

public interface ReporteDetalladoEmpleadoRestauranteOutputPort {
    List<Object> detalleEmpleadoRestauranteReporteDTO(UUID id);

}
