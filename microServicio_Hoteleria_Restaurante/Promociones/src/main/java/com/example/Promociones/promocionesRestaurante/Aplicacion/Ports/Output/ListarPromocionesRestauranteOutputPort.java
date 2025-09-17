package com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Output;

import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;

import java.util.List;
import java.util.UUID;

public interface ListarPromocionesRestauranteOutputPort {
    List<PromocionRestaurante> listarPromocionesRestaurante(List<UUID> id);

}
