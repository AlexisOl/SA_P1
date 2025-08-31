package com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;

import java.util.UUID;

public interface ListarReservacionEspecificaOutput {
    public Reservacion ListarReservacionEspecifica(UUID id);

}
