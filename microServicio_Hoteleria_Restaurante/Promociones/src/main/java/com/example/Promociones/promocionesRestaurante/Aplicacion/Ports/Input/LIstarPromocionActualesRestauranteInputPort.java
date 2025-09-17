package com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Input;

import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;

import java.util.UUID;

public interface LIstarPromocionActualesRestauranteInputPort {
    PromocionRestaurante ListarPromocionActual (UUID id);
}
