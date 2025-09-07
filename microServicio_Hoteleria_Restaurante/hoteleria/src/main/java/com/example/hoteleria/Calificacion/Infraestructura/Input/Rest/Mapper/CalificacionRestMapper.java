package com.example.hoteleria.Calificacion.Infraestructura.Input.Rest.Mapper;

import com.example.hoteleria.Calificacion.Dominio.Calificacion;
import com.example.hoteleria.Calificacion.Infraestructura.Input.Rest.Model.Input.RequestCalificacionDTO;
import com.example.hoteleria.Calificacion.Infraestructura.Input.Rest.Model.Output.ResponseCalificacionDTO;
import com.example.hoteleria.Calificacion.Infraestructura.Output.Entity.CalificacionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CalificacionRestMapper {


    Calificacion toCalificacion(RequestCalificacionDTO requestCalificacionDTO);

    ResponseCalificacionDTO toResponseCalificacion(Calificacion calificacion);


    List<ResponseCalificacionDTO> toListResponseCalificacionDtoList(List<Calificacion> listaCalificacion);
}
