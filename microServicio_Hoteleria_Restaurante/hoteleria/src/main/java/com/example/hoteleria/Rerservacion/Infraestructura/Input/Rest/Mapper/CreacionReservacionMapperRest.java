package com.example.hoteleria.Rerservacion.Infraestructura.Input.Rest.Mapper;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import com.example.hoteleria.Rerservacion.Infraestructura.Input.Rest.Model.Request.ReservacionRequestDTO;
import com.example.hoteleria.Rerservacion.Infraestructura.Input.Rest.Model.Response.ReservacionResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CreacionReservacionMapperRest {
    // creacion
    Reservacion toReservacion(ReservacionRequestDTO reservacionRequestDTO);
    @Mapping(source = "idusuario", target = "idusuario")
    @Mapping(target = "tipoReservacion", source = "tipoReservacion")

    ReservacionResponseDTO toReservacionResponseDTO(Reservacion reservacion);

    @Mapping(target = "tipoReservacion", source = "tipoReservacion")

    List<ReservacionResponseDTO> toListReservacionResponseDTO(List<Reservacion> reservacion);
}
