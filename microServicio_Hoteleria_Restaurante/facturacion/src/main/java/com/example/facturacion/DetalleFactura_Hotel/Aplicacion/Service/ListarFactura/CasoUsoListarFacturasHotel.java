package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Service.ListarFactura;

import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input.ListarFacturasDetalladasInputPort;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output.ListarFacturasDetalladasOutputPort;
import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasoUsoListarFacturasHotel implements ListarFacturasDetalladasInputPort {

    private final ListarFacturasDetalladasOutputPort  listarFacturasDetalladasOutputPort;

    public CasoUsoListarFacturasHotel(ListarFacturasDetalladasOutputPort listarFacturasDetalladasOutputPort) {
        this.listarFacturasDetalladasOutputPort =  listarFacturasDetalladasOutputPort;
    }

    @Override
    public List<DetalleFactura_Hotel> listarFacturas() {
        return this.listarFacturasDetalladasOutputPort.listarFacturas();
    }
}
