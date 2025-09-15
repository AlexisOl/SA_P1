package com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Input;

import com.example.Promociones.PromocionesHotel.Aplicacion.Service.CrearPromocionHotel.CrearPromocionDTO;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Service.CasoUsoCrearPromocion.CrearPromocionRestauranteDTO;
import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;

public interface CrearPromocionRestauranteInputPort {
    PromocionRestaurante crearPromocion(CrearPromocionRestauranteDTO promocion);

}
