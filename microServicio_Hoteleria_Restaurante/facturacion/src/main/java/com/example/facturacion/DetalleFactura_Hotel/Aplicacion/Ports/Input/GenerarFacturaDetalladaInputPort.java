package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input;

import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Service.GenerarFactura.GenerarFacturaDTO;
import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;

public interface GenerarFacturaDetalladaInputPort {

    DetalleFactura_Hotel generarDetalleFactura(GenerarFacturaDTO detalleFactura_Hotel) ;

}
