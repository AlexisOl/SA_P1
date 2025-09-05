package com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Mapper;

import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;
import com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Entity.FacturaRestauranteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface FacturaRestauranteMapper {

    FacturaRestauranteEntity toFAFacturaRestauranteEntity(FacturaRestaurante facturaRestaurante);

    FacturaRestaurante toFacturaRestaurante(FacturaRestauranteEntity facturaRestauranteEntity);
}
