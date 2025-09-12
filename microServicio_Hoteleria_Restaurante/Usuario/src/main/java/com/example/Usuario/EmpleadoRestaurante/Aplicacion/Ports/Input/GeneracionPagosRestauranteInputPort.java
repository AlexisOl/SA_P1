package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Input;

import java.util.List;
import java.util.UUID;

public interface GeneracionPagosRestauranteInputPort {
    List<Object> perdidasPagosRestaurante(UUID id);

}
