package com.example.Restaurante.Calificacion.Aplicacion.Ports.Output;

import com.example.Restaurante.Calificacion.Aplicacion.Service.CrearCalificacion.CrearCalificacionRestauranteDTO;
import com.example.Restaurante.Calificacion.Dominio.CalificacionRestaurante;

public interface CrearCalificacionRestauranteOutputPort {
    CalificacionRestaurante createCalificacionRestaurante(CalificacionRestaurante calificacionRestaurante);

}
