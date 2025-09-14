package com.example.hoteleria.Rerservacion.Aplicacion.Ports.Input;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;

import java.util.UUID;

public interface CambiarEstadoReservacionInputPort {

    Reservacion cambioEstado(UUID id, String estado) throws Exception;


}
