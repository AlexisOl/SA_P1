package com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Output;

import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;

import java.util.List;
import java.util.UUID;

public interface ListarFacturasUsuarioOutputPort {
    List<FacturaRestaurante> listarFacturas(UUID idUsuario);

}
