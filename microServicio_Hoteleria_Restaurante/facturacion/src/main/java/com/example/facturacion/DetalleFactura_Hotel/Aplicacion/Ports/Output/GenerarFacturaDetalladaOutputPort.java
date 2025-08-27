package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output;

import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;

public interface GenerarFacturaDetalladaOutputPort {

    DetalleFactura_Hotel GenerarFacturaDetallada(DetalleFactura_Hotel detalleFactura_Hotel);
}
