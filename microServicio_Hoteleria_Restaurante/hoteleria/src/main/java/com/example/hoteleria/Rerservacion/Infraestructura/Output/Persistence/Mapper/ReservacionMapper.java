package com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Mapper;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Entity.ReservacionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservacionMapper {

    Reservacion toReservacion(ReservacionEntity reservacionEntity);
    ReservacionEntity toReservacionEntity(Reservacion reservacion);

}
