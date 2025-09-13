package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output;

import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;

import java.util.Optional;
import java.util.UUID;

public interface ListarFacturaReservacionEspecificaOutputPort {
    DetalleFactura_Hotel obtenerDetalleFacturacionEspecifica(UUID id);

}
