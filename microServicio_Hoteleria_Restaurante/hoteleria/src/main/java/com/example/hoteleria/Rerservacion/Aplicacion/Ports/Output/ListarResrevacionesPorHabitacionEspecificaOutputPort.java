package com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;

import java.util.List;
import java.util.UUID;

public interface ListarResrevacionesPorHabitacionEspecificaOutputPort {

    List<Reservacion> ListarRersvacionesHabitacionesEspecifca(UUID id);
}
