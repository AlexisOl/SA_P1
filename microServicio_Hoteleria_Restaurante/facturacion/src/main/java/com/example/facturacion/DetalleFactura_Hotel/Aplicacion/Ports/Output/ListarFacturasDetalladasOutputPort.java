package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output;

import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;

import java.util.List;

public interface ListarFacturasDetalladasOutputPort {

    List<DetalleFactura_Hotel> listarFacturas();

}
