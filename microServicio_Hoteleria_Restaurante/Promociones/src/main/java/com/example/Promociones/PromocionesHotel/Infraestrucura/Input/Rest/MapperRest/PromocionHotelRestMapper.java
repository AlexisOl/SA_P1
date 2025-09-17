package com.example.Promociones.PromocionesHotel.Infraestrucura.Input.Rest.MapperRest;

import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Input.Rest.Model.Response.ResponsePromocionHotelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface PromocionHotelRestMapper {

    ResponsePromocionHotelDTO toResponsePromocionHotelDto(PromocionesHotel promocionesHotel);
    List<ResponsePromocionHotelDTO> toResponsePromocionHotelDtoList(List<PromocionesHotel> promocionesHotel);
}
