package com.example.facturacion.Factura_Restaurante.Aplicacion.Service.ListarFacturas;

import com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Input.ListarFacturasUsuarioInputPort;
import com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Output.ListarFacturasUsuarioOutputPort;
import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CasoUsoListarFacturas implements ListarFacturasUsuarioInputPort {

    private final ListarFacturasUsuarioOutputPort listarFacturasUsuarioOutputPort;


    public CasoUsoListarFacturas(ListarFacturasUsuarioOutputPort listarFacturasUsuarioOutputPort){
        this.listarFacturasUsuarioOutputPort = listarFacturasUsuarioOutputPort;
    }
    @Override
    public List<FacturaRestaurante> listarFacturas(UUID idUsuario) {

        // ver si existe el usuario
        return this.listarFacturasUsuarioOutputPort.listarFacturas(idUsuario);
    }
}
