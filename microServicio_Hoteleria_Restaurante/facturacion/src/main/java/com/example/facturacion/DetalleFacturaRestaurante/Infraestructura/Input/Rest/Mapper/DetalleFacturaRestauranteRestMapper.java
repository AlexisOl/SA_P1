package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Input.Rest.Mapper;

import com.example.facturacion.DetalleFacturaRestaurante.Dominio.DetalleFacturaRestaurante;
import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Input.Rest.Model.Output.ResponseDetalleFacturaRestauranteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface DetalleFacturaRestauranteRestMapper {


    ResponseDetalleFacturaRestauranteDTO toDetalleFacturaRestauranteDTO(DetalleFacturaRestaurante detalleFacturaRestaurante);
    List<ResponseDetalleFacturaRestauranteDTO> toListDetalleFacturaRestauranteDTO(List<DetalleFacturaRestaurante> detalleFacturaRestaurante);
}
