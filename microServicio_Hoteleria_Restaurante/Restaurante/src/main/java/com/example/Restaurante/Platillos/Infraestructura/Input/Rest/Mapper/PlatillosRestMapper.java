package com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Mapper;

import com.example.Restaurante.Platillos.Dominio.Platillos;
import com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Model.Input.RequestPlatillosDTO;
import com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Model.Output.ResponsePlatillosDTO;
import com.example.Restaurante.Platillos.Infraestructura.Output.Entity.PlatillosEntity;
import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import com.example.Restaurante.Restaurante.Infraestructura.Input.Rest.Model.Output.ResponseRestauranteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface PlatillosRestMapper {
 //   Platillos toPlatillos(RequestPlatillosDTO requestPlatillosDTO);
 @Mapping(source = "promedio_valoracion", target = "promedio_valoracion")
    ResponsePlatillosDTO toResponsePlatillosDTO(Platillos platillos );
    @Mapping(source = "promedio_valoracion", target = "promedio_valoracion")
    List<ResponsePlatillosDTO> toListPlatillosResponse(List<Platillos> platillos);

}
