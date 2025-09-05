package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Output.Mapper;

import com.example.facturacion.DetalleFacturaRestaurante.Dominio.DetalleFacturaRestaurante;
import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Output.Entity.DetalleFacturaRestauranteEntity;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Entity.DetalleFacturaEntity;
import com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Mapper.FacturaRestauranteMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {FacturaRestauranteMapper.class})
public interface DetalleFacturaRestauranteMapper {
    @Mapping(source = "facturaRestaurante", target = "facturaRestaurante")
    DetalleFacturaRestauranteEntity toDetalleFacturaEntity(DetalleFacturaRestaurante detalleFacturaRestaurante);
    @Mapping(source = "facturaRestaurante", target = "facturaRestaurante")
    DetalleFacturaRestaurante toFacturaRestaurante(DetalleFacturaRestauranteEntity detalleFacturaRestaurante);
}
