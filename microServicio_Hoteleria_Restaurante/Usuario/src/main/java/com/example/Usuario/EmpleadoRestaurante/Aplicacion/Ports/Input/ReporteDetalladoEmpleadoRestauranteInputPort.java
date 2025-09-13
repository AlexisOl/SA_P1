package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Input;

import java.util.List;
import java.util.UUID;

public interface ReporteDetalladoEmpleadoRestauranteInputPort {
    List<Object> detalleEmpleadoRestauranteReporteDTO(UUID id);

}
