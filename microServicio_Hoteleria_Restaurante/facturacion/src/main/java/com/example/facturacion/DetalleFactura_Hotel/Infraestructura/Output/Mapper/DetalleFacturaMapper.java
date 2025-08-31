package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Mapper;

import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Entity.DetalleFacturaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetalleFacturaMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "id_reservacion", target = "id_reservacion")
    DetalleFacturaEntity toDetalleFacturaEntity (DetalleFactura_Hotel detalleFactura_Hotel);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "fecha", target = "fecha")
    @Mapping(source = "id_reservacion", target = "id_reservacion")
    DetalleFactura_Hotel toDetalleFactura_Hotel (DetalleFacturaEntity detalleFacturaEntity);


    List<DetalleFactura_Hotel> toListDetalleFactura_Hotel (List<DetalleFacturaEntity> detalleFacturaEntities);
    List<DetalleFacturaEntity> toListDetalleFacturaEntities (List<DetalleFactura_Hotel> detalleFacturaHotels);

}
