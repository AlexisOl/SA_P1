package com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Output;

import com.example.Promociones.promocionesRestaurante.Aplicacion.Service.CasoUsoCrearPromocion.CrearPromocionRestauranteDTO;
import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;

public interface CrearPromocionRestauranteOutputPort {
    PromocionRestaurante crearPromocion(PromocionRestaurante promocion);

}
