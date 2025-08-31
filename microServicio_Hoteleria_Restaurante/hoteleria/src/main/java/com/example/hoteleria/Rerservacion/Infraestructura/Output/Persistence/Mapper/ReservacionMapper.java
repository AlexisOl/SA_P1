package com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Mapper;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Entity.ReservacionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservacionMapper {

    Reservacion toReservacion(ReservacionEntity reservacionEntity);
    ReservacionEntity toReservacionEntity(Reservacion reservacion);


    List<ReservacionEntity> toReservacionEntityList(List<Reservacion> reservacionList);
    List<Reservacion> toReservacionList(List<ReservacionEntity> reservacionEntityList);
}
