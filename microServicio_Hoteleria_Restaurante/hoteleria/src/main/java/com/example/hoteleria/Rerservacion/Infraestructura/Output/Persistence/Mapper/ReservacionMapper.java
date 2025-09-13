package com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Mapper;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Entity.ReservacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservacionMapper {


    @Mapping(target = "tipoReservacion", source = "tipoReservacion")
    Reservacion toReservacion(ReservacionEntity reservacionEntity);
    ReservacionEntity toReservacionEntity(Reservacion reservacion);


    List<ReservacionEntity> toReservacionEntityList(List<Reservacion> reservacionList);
    @Mapping(target = "tipoReservacion", source = "tipoReservacion")
    List<Reservacion> toReservacionList(List<ReservacionEntity> reservacionEntityList);
}
