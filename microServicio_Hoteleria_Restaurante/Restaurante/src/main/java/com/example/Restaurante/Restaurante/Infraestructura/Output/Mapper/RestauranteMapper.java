package com.example.Restaurante.Restaurante.Infraestructura.Output.Mapper;

import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import com.example.Restaurante.Restaurante.Infraestructura.Output.Entity.RestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface RestauranteMapper {

    Restaurante ToRestaurante(RestauranteEntity restauranteEntity);
    @Mapping(source = "id", target = "id")
    RestauranteEntity toRestauranteEntity(Restaurante  restaurante);


    List<Restaurante> toRestaurantesList(List<RestauranteEntity> restaurantesEntity);

    @Mapping(source = "id", target = "id")
    List<RestauranteEntity> toRestaurantesEntityList(List<Restaurante> restaurantes);

}
