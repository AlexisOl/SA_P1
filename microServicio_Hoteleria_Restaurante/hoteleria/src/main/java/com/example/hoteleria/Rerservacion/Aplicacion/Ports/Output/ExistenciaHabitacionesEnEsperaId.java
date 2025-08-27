package com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output;

import com.example.hoteleria.Rerservacion.Dominio.TipoReservacion;

import java.util.UUID;

public interface ExistenciaHabitacionesEnEsperaId {

    public boolean existenciaHabitacionesEnEsperaId(UUID id_habitacion, TipoReservacion Estado);

}
