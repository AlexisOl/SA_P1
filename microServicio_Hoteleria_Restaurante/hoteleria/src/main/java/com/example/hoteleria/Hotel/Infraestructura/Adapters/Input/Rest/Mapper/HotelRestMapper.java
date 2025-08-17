package com.example.hoteleria.Hotel.Infraestructura.Adapters.Input.Rest.Mapper;


import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Input.Rest.Model.Request.CreacionHotelRequest;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Input.Rest.Model.Response.HotelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;


// que ignore lo que no esta mapeado
@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HotelRestMapper {

    // para que lo establezca en la creacion
    Hotel toHotelMapper(CreacionHotelRequest hotel);

    // para devolver lo que sucede
    HotelResponse  toHotelResponseMapper(Hotel hotel);

    List<HotelResponse> toHotelResponseList(List<Hotel> hoteles);

}
