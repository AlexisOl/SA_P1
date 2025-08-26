package com.example.hoteleria.Rerservacion.Aplicacion.Ports.Input;

import com.example.hoteleria.Rerservacion.Aplicacion.Service.CasosUso.CrearReservacion.CrearReservacionDTO;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import jakarta.validation.Valid;

public interface CrearReservacionInputPort {

    Reservacion crearReservacion(@Valid CrearReservacionDTO crearReservacionDTO);
}
