package com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;

import java.util.List;

public interface ListarReservacionesHotelOutputPort {
    List<Reservacion> listarReservacionesHotel(Long id);

}
