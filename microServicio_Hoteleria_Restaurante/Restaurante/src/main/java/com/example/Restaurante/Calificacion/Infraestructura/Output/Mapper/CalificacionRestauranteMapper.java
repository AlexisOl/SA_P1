package com.example.Restaurante.Calificacion.Infraestructura.Output.Mapper;

import com.example.Restaurante.Calificacion.Dominio.CalificacionRestaurante;
import com.example.Restaurante.Calificacion.Infraestructura.Output.Entity.CalificacionRestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CalificacionRestauranteMapper {
    @Mapping(source = "platillo", target = "platillo")
    CalificacionRestaurante toCalificacionRestaurante(CalificacionRestauranteEntity  calificacionRestauranteEntity);

    @Mapping(source = "platillo", target = "platillo")
    CalificacionRestauranteEntity toCalificacionRestauranteEntity(CalificacionRestaurante calificacionRestaurante);
}
