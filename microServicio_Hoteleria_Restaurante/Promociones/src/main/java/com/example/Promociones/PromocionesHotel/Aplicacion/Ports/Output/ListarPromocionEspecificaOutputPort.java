package com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output;

import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;

import java.util.UUID;

public interface ListarPromocionEspecificaOutputPort {
    PromocionesHotel ListarPromocionEspecifica(UUID id);

}
