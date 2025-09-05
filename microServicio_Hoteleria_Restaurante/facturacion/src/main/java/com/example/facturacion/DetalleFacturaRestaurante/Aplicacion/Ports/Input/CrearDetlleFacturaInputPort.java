package com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Input;

import com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Service.CrearDetalleFactura.CrearDetlleFacturaDTO;
import com.example.facturacion.DetalleFacturaRestaurante.Dominio.DetalleFacturaRestaurante;

public interface CrearDetlleFacturaInputPort {

    DetalleFacturaRestaurante createDetalleFacturaRestaurante(CrearDetlleFacturaDTO crearDetlleFacturaDTO);
}
