package com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Output;

import com.example.facturacion.DetalleFacturaRestaurante.Dominio.DetalleFacturaRestaurante;

import java.util.List;
import java.util.UUID;

public interface ListarDetallaFacturaRestauranteEspecificaOutputPort {
    List<DetalleFacturaRestaurante> ListarDetalleFactura(UUID id);

}
