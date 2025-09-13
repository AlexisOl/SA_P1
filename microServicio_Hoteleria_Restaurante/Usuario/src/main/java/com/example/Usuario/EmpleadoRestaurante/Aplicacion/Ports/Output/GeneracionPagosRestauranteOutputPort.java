package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output;

import java.util.List;
import java.util.UUID;

public interface GeneracionPagosRestauranteOutputPort {
    List<Object> perdidasPagosRestaurante(UUID id);

}
