package com.example.Restaurante.Restaurante.Infraestructura.Input.Rest.Mapper;


import com.example.Restaurante.Restaurante.Aplicacion.Service.CasoUsoCreacionRestaurante.CreacionRestauranteDTO;
import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import com.example.Restaurante.Restaurante.Infraestructura.Input.Rest.Model.Input.RequestRestauranteDTO;
import com.example.Restaurante.Restaurante.Infraestructura.Input.Rest.Model.Output.ResponseRestauranteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface RestauranteRestMappper {
    Restaurante toRestaurante(CreacionRestauranteDTO requestRestauranteDTO);


    ResponseRestauranteDTO toRestauranteResponse(Restaurante restaurante);


    List<ResponseRestauranteDTO> toListRestauranteResponse(List<Restaurante> restaurante);
}
