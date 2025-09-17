package com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Output;

import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;

import java.time.LocalDate;
import java.util.UUID;

public interface ListarPromocionesRestauranteActualesOutputPort {
    PromocionRestaurante listarPromocionesRestaurante(UUID id, LocalDate fecha);

}
