package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Input.Rest.Mapper;

import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Input.Rest.Model.Request.DetalleFacturaRequestDTO;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Input.Rest.Model.Response.DetalleFacturaResponseDTO;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Entity.DetalleFacturaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "Spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CreacionDetalleFacturaRestMapper {

    DetalleFactura_Hotel toDetalleFactura_Hotel(DetalleFacturaRequestDTO detalleFacturaRequestDTO);

    DetalleFacturaResponseDTO toDetalleFacturaResponseDTO(DetalleFactura_Hotel detalleFacturaHotel);

    List<DetalleFacturaResponseDTO> toDetalleFacturaResponseDTO(List<DetalleFactura_Hotel> detalleFacturaHotels);

}
