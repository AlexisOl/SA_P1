package com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Input;

import com.example.facturacion.DetalleFacturaRestaurante.Dominio.DetalleFacturaRestaurante;

import java.util.List;
import java.util.UUID;

public interface ListarDetallaFacturaRestauranteEspecificaInputPort {

    List<DetalleFacturaRestaurante> ListarDetalleFactura(UUID id);
}
