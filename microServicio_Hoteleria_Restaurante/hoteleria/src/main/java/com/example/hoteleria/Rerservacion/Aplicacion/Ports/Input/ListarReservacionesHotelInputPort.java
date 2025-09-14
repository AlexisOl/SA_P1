package com.example.hoteleria.Rerservacion.Aplicacion.Ports.Input;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;

import java.util.List;
import java.util.UUID;

public interface ListarReservacionesHotelInputPort {

    List<Reservacion> listarReservacionesHotel(Long id);


}
