package com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence.Mapper;


import com.example.hoteleria.Habitaciones.Aplicacion.Service.CrearHabitacion.CrearHabitacionDTO;
import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence.Entity.HabitacionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface HabitacionMapper {

    Habitacion toHabitacion(HabitacionEntity habitacionEntity);
    HabitacionEntity toHabitacionEntity(Habitacion habitacion);
    HabitacionEntity toHabitacionEntity(CrearHabitacionDTO crearHabitacionDTO);
    List<HabitacionEntity> toHabitacionEntityList(List<Habitacion> habitaciones);
    List<Habitacion>  toHabitacionList(List<HabitacionEntity> habitaciones);
}
