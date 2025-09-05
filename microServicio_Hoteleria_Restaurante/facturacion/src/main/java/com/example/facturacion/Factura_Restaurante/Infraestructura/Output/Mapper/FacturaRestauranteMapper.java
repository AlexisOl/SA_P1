package com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Mapper;

import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;
import com.example.facturacion.Factura_Restaurante.Dominio.ObjetosValor.PrecioFactura;
import com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Entity.FacturaRestauranteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface FacturaRestauranteMapper {
    @Mapping(source = "precioTotal", target = "precioTotal")
    FacturaRestauranteEntity toFAFacturaRestauranteEntity(FacturaRestaurante facturaRestaurante);

    @Mapping(source = "precioTotal", target = "precioTotal")
    FacturaRestaurante toFacturaRestaurante(FacturaRestauranteEntity facturaRestauranteEntity);


    default Double map(PrecioFactura value) {
        return value != null ? value.getPrecioTotal() : null;
    }

    default PrecioFactura map(Double value) {
        return value != null ? new PrecioFactura(value) : null;
    }
}
