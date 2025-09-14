package com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import com.example.hoteleria.Rerservacion.Dominio.TipoReservacion;

import java.util.UUID;

public interface CambiarEstadoReservacionOutputPort {

    Reservacion cambiarEstadoReservacion(Reservacion reservacion);
}
