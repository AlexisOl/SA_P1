package com.example.hoteleria.Calificacion.Aplicacion.Ports.Input;

import com.example.hoteleria.Calificacion.Aplicacion.Service.CasosUso.CrearCalificacionCasoUso.CrearCalificacionDTO;
import com.example.hoteleria.Calificacion.Dominio.Calificacion;

public interface CrearCalificacionInputPort {

    Calificacion crearCalificacion(CrearCalificacionDTO crearCalificacionDTO);
}
