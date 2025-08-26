package com.example.hoteleria.Rerservacion.Infraestructura.Input.Rest.Mapper;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import com.example.hoteleria.Rerservacion.Infraestructura.Input.Rest.Model.Request.ReservacionRequestDTO;
import com.example.hoteleria.Rerservacion.Infraestructura.Input.Rest.Model.Response.ReservacionResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CreacionReservacionMapperRest {
    // creacion
    Reservacion toReservacion(ReservacionRequestDTO reservacionRequestDTO);

    ReservacionResponseDTO toReservacionResponseDTO(Reservacion reservacion);
}
