package com.example.Promociones.promocionesRestaurante.Infraestrucura.Output.Mapper;

import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Output.Entitty.PromocionHotelEntity;
import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;
import com.example.Promociones.promocionesRestaurante.Infraestrucura.Output.Entitty.PromocionRestauranteEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface PromocionRestauranteMapper {
    PromocionRestauranteEntity toPromocionRestauranteEntity(PromocionRestaurante promocionRestaurante);
    PromocionRestaurante toPromocionRestaurante(PromocionRestauranteEntity promocionRestaurante);

    List<PromocionRestaurante> toPromocionRestauranteList(List<PromocionRestauranteEntity> promocionRestauranteEntities);
}
