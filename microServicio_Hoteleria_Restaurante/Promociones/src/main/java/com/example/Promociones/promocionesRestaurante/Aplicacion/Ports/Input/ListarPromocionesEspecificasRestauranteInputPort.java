package com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Input;

import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;

import java.util.UUID;

public interface ListarPromocionesEspecificasRestauranteInputPort {
    PromocionRestaurante ListarPromocionEspecificaRestaurante(UUID id);

}
