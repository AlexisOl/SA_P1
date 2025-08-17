package com.example.hoteleria.Hotel.Infraestructura.Adapters.Output.Persistence.Mapper;


import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Output.Persistence.Entity.HotelEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelPersitenciaMapper {

    //mapeo entre valores de entidad de BD Y datos de valor
    HotelEntity toHotelEntity(Hotel hotel);

    Hotel toHotel(HotelEntity hotelEntity);


    List<Hotel> toHotelList(List<HotelEntity> hotelEntities);



}
