package com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;

public interface CrearReservacionOutputPort {

    Reservacion crearReservacion(Reservacion reservacion);
}
