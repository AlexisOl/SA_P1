package com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Input;

import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;

import java.util.List;
import java.util.UUID;

public interface ListarPromocionesRestauranteInputPort {
    List<PromocionRestaurante> listarPromocionesRestaurante(UUID id);

}
