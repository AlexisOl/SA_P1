package com.example.Usuario.EmpleadoHotel.Infraestructura.Input.Rest.Mapper;

import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Input.Rest.Model.Input.RequestEmpleadoHotelDTO;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Input.Rest.Model.Output.ResponseEmpleadoHotelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface EmpleadoHotelRestMapper {
    EmpleadoHotel toEmpleadoHotel(RequestEmpleadoHotelDTO requestEmpleadoHotelDTO);

    ResponseEmpleadoHotelDTO  toResponseEmpleadoHotel(EmpleadoHotel empleadoHotel);
}
