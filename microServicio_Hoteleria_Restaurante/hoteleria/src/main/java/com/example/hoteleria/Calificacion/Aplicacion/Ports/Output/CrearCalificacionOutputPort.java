package com.example.hoteleria.Calificacion.Aplicacion.Ports.Output;

import com.example.hoteleria.Calificacion.Aplicacion.Service.CrearCalificacionCasoUso.CrearCalificacionDTO;
import com.example.hoteleria.Calificacion.Dominio.Calificacion;

public interface CrearCalificacionOutputPort {
    Calificacion crearCalificacion(Calificacion calificacion);

}
