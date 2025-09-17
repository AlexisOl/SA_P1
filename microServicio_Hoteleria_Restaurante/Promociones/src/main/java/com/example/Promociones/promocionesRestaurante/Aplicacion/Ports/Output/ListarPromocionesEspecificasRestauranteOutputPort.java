package com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Output;

import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;

import java.util.UUID;

public interface ListarPromocionesEspecificasRestauranteOutputPort {
    PromocionRestaurante ListarPromocionEspecificaRestaurante(UUID id);

}
