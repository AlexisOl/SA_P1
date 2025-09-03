package com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Mapper;

import com.example.Restaurante.Platillos.Dominio.Platillos;
import com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Model.Input.RequestPlatillosDTO;
import com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Model.Output.ResponsePlatillosDTO;
import com.example.Restaurante.Platillos.Infraestructura.Output.Entity.PlatillosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface PlatillosRestMapper {
 //   Platillos toPlatillos(RequestPlatillosDTO requestPlatillosDTO);
    ResponsePlatillosDTO toResponsePlatillosDTO(Platillos platillos );
}
