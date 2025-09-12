package com.example.Restaurante.Calificacion.Aplicacion.Ports.Output;

import com.example.Restaurante.Calificacion.Dominio.CalificacionRestaurante;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface ListarComentarioPlatilloOutputPort {
    List<CalificacionRestaurante> listarComentarioPlatillo(@PathVariable UUID id);

}
