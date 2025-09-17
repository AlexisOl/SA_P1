package com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input;

import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface LIstarPromocionesActualesHotelInputPort {
    //fecha de hoy
    PromocionesHotel listarPromocionesHotel(UUID id);

}
