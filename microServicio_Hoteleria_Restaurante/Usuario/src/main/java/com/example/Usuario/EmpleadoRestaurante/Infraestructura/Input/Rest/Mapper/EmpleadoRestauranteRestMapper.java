package com.example.Usuario.EmpleadoRestaurante.Infraestructura.Input.Rest.Mapper;

import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Input.Rest.Model.Output.ResponseEmpleadoHotelDTO;
import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;
import com.example.Usuario.EmpleadoRestaurante.Infraestructura.Input.Rest.Model.Output.ResponseEmpleadoRestauranteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface EmpleadoRestauranteRestMapper {
    ResponseEmpleadoRestauranteDTO toResponseEmpleadoRestauranteDto(EmpleadoRestaurante empleadoRestaurante);

    List<ResponseEmpleadoRestauranteDTO> toListResponseEmpleadoRestaurante(List<EmpleadoRestaurante> empleadoRestaurantes);
}
