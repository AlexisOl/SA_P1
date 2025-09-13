package com.example.Restaurante.Calificacion.Aplicacion.Ports.Input;

import com.example.Restaurante.Calificacion.Dominio.CalificacionRestaurante;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface ListarComentarioPlatilloInputPort {
    List<CalificacionRestaurante>  listarComentarioPlatillo(@PathVariable UUID id);
}
