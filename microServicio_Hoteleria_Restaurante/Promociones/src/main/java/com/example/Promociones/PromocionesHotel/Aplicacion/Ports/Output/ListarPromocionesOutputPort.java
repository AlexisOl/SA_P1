package com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output;

import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;

import java.util.List;
import java.util.UUID;

public interface ListarPromocionesOutputPort {
    List<PromocionesHotel> listarPromocionesHotel(List<UUID> id);

}
