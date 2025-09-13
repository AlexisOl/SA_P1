package com.example.facturacion.Factura_Restaurante.Infraestructura.Input.Rest.Mapper;

import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;
import com.example.facturacion.Factura_Restaurante.Dominio.ObjetosValor.PrecioFactura;
import com.example.facturacion.Factura_Restaurante.Infraestructura.Input.Rest.Model.Output.ResponseFacturaRestauranteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface FacturaRestauranteRestMapper {

    ResponseFacturaRestauranteDTO toResponseFacturaRestauranteDTO(FacturaRestaurante facturaRestaurante);

    List<ResponseFacturaRestauranteDTO> toListResponseFacturaRestauranteDTO(List<FacturaRestaurante> facturaRestauranteList);

    default Double map(PrecioFactura value) {
        return value != null ? value.getPrecioTotal() : null;
    }

    default PrecioFactura map(Double value) {
        return value != null ? new PrecioFactura(value) : null;
    }
}
