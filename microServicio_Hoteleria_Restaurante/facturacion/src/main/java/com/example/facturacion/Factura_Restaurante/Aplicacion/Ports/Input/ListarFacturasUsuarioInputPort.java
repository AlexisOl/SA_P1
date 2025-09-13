package com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Input;

import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;

import java.util.List;
import java.util.UUID;

public interface ListarFacturasUsuarioInputPort {
    List<FacturaRestaurante> listarFacturas(UUID idUsuario);
}
