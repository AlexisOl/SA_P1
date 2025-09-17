package com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output;

import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface LIstarPromocionesActualesHotelOutputPort {
    PromocionesHotel listarPromocionesHotel(UUID id, LocalDate fecha);

}
