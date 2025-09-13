package com.example.Usuario.EmpleadoHotel.Infraestructura.Output.Mapper;

import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Output.Entity.EmpleadoHotelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface EmpleadoHotelMapper {

    @Mapping(target = "fecha", expression = "java(com.example.Usuario.EmpleadoHotel.Dominio.ObjetosValor.FechaTrabajo.fromDatabase(empleadoHotelEntity.getFecha()))")
    EmpleadoHotel toEmpleadoHotel(EmpleadoHotelEntity empleadoHotelEntity);

    @Mapping(target = "fecha", expression = "java(empleadoHotel.getFecha().getFecha())")
    EmpleadoHotelEntity toEmpleadoHotelEntity(EmpleadoHotel empleadoHotel);

    @Mapping(target = "fecha", expression = "java(com.example.Usuario.EmpleadoHotel.Dominio.ObjetosValor.FechaTrabajo.fromDatabase(empleadoHotelEntity.getFecha()))")
    List<EmpleadoHotel> toListEmpleadoHotel(List<EmpleadoHotelEntity> empleadoHotelEntities);

    List<EmpleadoHotelEntity> toListEmpleadoHotelEntity(List<EmpleadoHotel> empleadoHotels);
}