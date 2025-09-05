package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Output.Mapper;

import com.example.facturacion.DetalleFacturaRestaurante.Dominio.DetalleFacturaRestaurante;
import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Output.Entity.DetalleFacturaRestauranteEntity;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Entity.DetalleFacturaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetalleFacturaRestauranteMapper {

    DetalleFacturaRestauranteEntity toDetalleFacturaEntity(DetalleFacturaRestaurante detalleFacturaRestaurante);

    DetalleFacturaRestaurante toFacturaRestaurante(DetalleFacturaRestauranteEntity detalleFacturaRestaurante);
}
