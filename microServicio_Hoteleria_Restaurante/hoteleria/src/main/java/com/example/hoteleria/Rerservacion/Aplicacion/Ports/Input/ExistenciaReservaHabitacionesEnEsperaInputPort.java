package com.example.hoteleria.Rerservacion.Aplicacion.Ports.Input;

import com.example.hoteleria.Rerservacion.Dominio.TipoReservacion;

import java.util.UUID;

public interface ExistenciaReservaHabitacionesEnEsperaInputPort {
    boolean existeReservaEnEspera(UUID id_reserva, TipoReservacion Estado);
}
