package com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Mapper;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Request.crearHabitacionRequestDTO;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Response.CrearHabitacionResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CreacionHabitacionRestMapper {
    Habitacion toHabitacion(crearHabitacionRequestDTO habitacion);

    CrearHabitacionResponseDTO toHabitacionResponse(Habitacion habitacion);
}
