package com.example.Restaurante.Platillos.Infraestructura.Output.Mapper;

import com.example.Restaurante.Platillos.Dominio.Platillos;
import com.example.Restaurante.Platillos.Infraestructura.Output.Entity.PlatillosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface PlatillosMapper {
    Platillos toPlatillos(PlatillosEntity platillosEntity);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "idrestaurante", target = "idrestaurante")
    PlatillosEntity toPlatillosEntity(Platillos platillos);


    List<Platillos> toListPlatillos(List<PlatillosEntity> platillosEntities);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "idrestaurante", target = "idrestaurante")
    List<PlatillosEntity> toListPlatillosEntity(List<Platillos> platillosEntities);
}
