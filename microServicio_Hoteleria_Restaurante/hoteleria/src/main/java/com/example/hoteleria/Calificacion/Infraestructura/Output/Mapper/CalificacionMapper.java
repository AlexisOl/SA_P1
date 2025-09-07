package com.example.hoteleria.Calificacion.Infraestructura.Output.Mapper;

import com.example.hoteleria.Calificacion.Dominio.Calificacion;
import com.example.hoteleria.Calificacion.Infraestructura.Output.Entity.CalificacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CalificacionMapper {


    @Mapping(target = "id", source = "id")
    @Mapping(target = "reservacion", source = "reservacion")
    @Mapping(target = "comentario", source = "comentario")
    @Mapping(target = "puntuacion", source = "puntuacion")
    Calificacion toCalificacion(CalificacionEntity calificacionEntity);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "reservacion", source = "reservacion")
    @Mapping(target = "comentario", source = "comentario")
    @Mapping(target = "puntuacion", source = "puntuacion")
    CalificacionEntity toCalificacionEntity(Calificacion calificacion);



    List<Calificacion> toCalificacionList(List<CalificacionEntity> calificacionEntities);



    List<CalificacionEntity> toCalificacionEntityList(List<Calificacion> calificaciones);
}
