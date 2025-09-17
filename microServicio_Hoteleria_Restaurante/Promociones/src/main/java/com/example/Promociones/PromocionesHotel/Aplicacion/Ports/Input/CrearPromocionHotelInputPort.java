package com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input;

import com.example.Promociones.PromocionesHotel.Aplicacion.Service.CrearPromocionHotel.CrearPromocionDTO;
import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;

public interface CrearPromocionHotelInputPort {
    PromocionesHotel crearPromocion(CrearPromocionDTO promocion);
}
