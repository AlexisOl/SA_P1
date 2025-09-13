package com.example.Restaurante.Calificacion.Infraestructura.Input.Rest.Mapper;

import com.example.Restaurante.Calificacion.Dominio.CalificacionRestaurante;
import com.example.Restaurante.Calificacion.Infraestructura.Input.Rest.Model.Output.ResponseCalificacionPlatilloDTO;
import com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Model.Input.RequestPlatillosDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CalificacionRestauranteRestMapper {

    CalificacionRestaurante toCalificacionRestaurante(RequestPlatillosDTO requestPlatillosDTO);


    ResponseCalificacionPlatilloDTO toResponseCalificacionPlatilloDto(CalificacionRestaurante calificacionRestaurante);
    List<ResponseCalificacionPlatilloDTO> toListResponseCalificacionPlatilloDto(List<CalificacionRestaurante> calificacionRestaurante);
}
