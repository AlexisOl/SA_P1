package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input;

import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;

import java.util.List;

public interface ListarFacturasDetalladasInputPort {

    List<DetalleFactura_Hotel> listarFacturas();

}
