package com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Mapper;

import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;
import com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Entity.EmpleadoRestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoRestauranteMapper {

    @Mapping(target = "fecha", expression = "java(new com.example.Usuario.EmpleadoRestaurante.Dominio.ObjetosValor.FechaTrabajo(empleadoRestauranteEntity.getFecha()))")
    @Mapping(target = "restauranteId", source = "restauranteId")
    EmpleadoRestaurante toEmpleadoRestaurante(EmpleadoRestauranteEntity empleadoRestauranteEntity);

    @Mapping(target = "restauranteId", source = "restauranteId")

    @Mapping(target = "fecha", expression = "java(empleadoRestaurante.getFecha().getFecha())")
    EmpleadoRestauranteEntity  toEmpleadoRestauranteEntity(EmpleadoRestaurante empleadoRestaurante);
    @Mapping(target = "restauranteId", source = "restauranteId")

    @Mapping(target = "fecha", expression = "java(new com.example.Usuario.EmpleadoRestaurante.Dominio.ObjetosValor.FechaTrabajo(empleadoRestauranteEntity.getFecha()))")

    List<EmpleadoRestaurante> toListEmpleadoRestaurante(List<EmpleadoRestauranteEntity> empleadoRestauranteEntities);
}
