package com.example.Restaurante.Calificacion.Aplicacion.Ports.Input;

import com.example.Restaurante.Calificacion.Aplicacion.Service.CrearCalificacion.CrearCalificacionRestauranteDTO;
import com.example.Restaurante.Calificacion.Dominio.CalificacionRestaurante;

import java.util.List;

public interface CrearCalificacionRestauranteInputPort {

    CalificacionRestaurante createCalificacionRestaurante(List<CrearCalificacionRestauranteDTO> crearCalificacionRestauranteDTO);
}
