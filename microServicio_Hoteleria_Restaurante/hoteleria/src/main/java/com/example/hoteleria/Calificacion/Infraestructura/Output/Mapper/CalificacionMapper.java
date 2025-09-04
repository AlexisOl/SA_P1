package com.example.hoteleria.Calificacion.Infraestructura.Output.Mapper;

import com.example.hoteleria.Calificacion.Dominio.Calificacion;
import com.example.hoteleria.Calificacion.Infraestructura.Output.Entity.CalificacionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CalificacionMapper {

    Calificacion toCalificacion(CalificacionEntity calificacionEntity);

    CalificacionEntity toCalificacionEntity(Calificacion calificacion);


    List<Calificacion> toCalificacion(List<CalificacionEntity> calificacionEntities);

    List<CalificacionEntity> toCalificacionEntityList(List<Calificacion> calificaciones);
}
