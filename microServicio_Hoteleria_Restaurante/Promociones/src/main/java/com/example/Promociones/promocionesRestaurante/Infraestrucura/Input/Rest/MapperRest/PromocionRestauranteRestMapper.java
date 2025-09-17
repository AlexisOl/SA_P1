package com.example.Promociones.promocionesRestaurante.Infraestrucura.Input.Rest.MapperRest;

import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Input.Rest.Model.Response.ResponsePromocionHotelDTO;
import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;
import com.example.Promociones.promocionesRestaurante.Infraestrucura.Input.Rest.Model.Response.ResponsePromcionRestauranteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface PromocionRestauranteRestMapper {
    ResponsePromcionRestauranteDTO toResponsePromcionRestauranteDto(PromocionRestaurante promocionRestaurante);
    List<ResponsePromcionRestauranteDTO> toResponsePromcionRestauranteDtos(List<PromocionRestaurante> promocionRestaurantes);
}
