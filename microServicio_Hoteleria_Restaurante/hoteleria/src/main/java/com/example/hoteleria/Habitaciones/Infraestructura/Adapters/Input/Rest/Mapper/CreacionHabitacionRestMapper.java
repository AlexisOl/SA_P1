package com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Mapper;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Request.ListarHabitacionesRequestDTO;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Request.crearHabitacionRequestDTO;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Response.BuscarHabitacionResponseDTO;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Response.CrearHabitacionResponseDTO;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Response.ListarHabitacionesResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CreacionHabitacionRestMapper {
    Habitacion toHabitacion(crearHabitacionRequestDTO habitacion);

    CrearHabitacionResponseDTO toHabitacionResponse(Habitacion habitacion);


    List<Habitacion> toHabitacionLista(List<ListarHabitacionesRequestDTO> habitacionesRequestDTO);
    @Mapping(source = "promedio_valoracion", target = "promedio_valoracion")
    List<ListarHabitacionesResponseDTO> toHabitacionesListaResponse(List<Habitacion> habitacion);

    Habitacion toHabitacion(BuscarHabitacionResponseDTO habitacion);
    @Mapping(source = "tipoHabitacion", target = "tipoHabitacion")
    @Mapping(source = "precio", target = "precio")
    @Mapping(source = "promedio_valoracion", target = "promedio_valoracion")
    BuscarHabitacionResponseDTO toBuscarHabitacionResponse(Habitacion habitacion);
}
