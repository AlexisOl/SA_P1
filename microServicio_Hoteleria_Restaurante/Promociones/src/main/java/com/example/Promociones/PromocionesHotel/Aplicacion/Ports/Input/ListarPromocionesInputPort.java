package com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input;

import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;

import java.util.List;

public interface ListarPromocionesInputPort {
    List<PromocionesHotel> listarPromocionesHotel(Long id);
}
