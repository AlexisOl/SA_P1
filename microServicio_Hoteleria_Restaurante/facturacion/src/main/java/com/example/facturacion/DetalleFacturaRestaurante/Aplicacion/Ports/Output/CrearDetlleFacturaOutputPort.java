package com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Output;

import com.example.facturacion.DetalleFacturaRestaurante.Dominio.DetalleFacturaRestaurante;

public interface CrearDetlleFacturaOutputPort
{

    DetalleFacturaRestaurante createDetalleFacturaRestaurante(DetalleFacturaRestaurante detalleFacturaRestaurante);
}
