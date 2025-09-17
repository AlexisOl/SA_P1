package com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input;

import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;

import java.util.UUID;

public interface ListarPromocionEspecificaInputPort {
   PromocionesHotel ListarPromocionEspecifica(UUID id);
}
