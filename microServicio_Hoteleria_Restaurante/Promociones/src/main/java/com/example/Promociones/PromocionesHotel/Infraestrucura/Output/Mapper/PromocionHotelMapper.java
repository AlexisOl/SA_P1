package com.example.Promociones.PromocionesHotel.Infraestrucura.Output.Mapper;

import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Output.Entitty.PromocionHotelEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface PromocionHotelMapper {

    PromocionHotelEntity toPromocionHotelEntity(PromocionesHotel promocionesHotel);
    PromocionesHotel toPromocionesHotel(PromocionHotelEntity promocionHotelEntity);

    List<PromocionesHotel> toPromocionesHotelList(List<PromocionHotelEntity> promocionHotelEntities);
}
