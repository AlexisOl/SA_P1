package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Service.ListarFacturaReservacionEspecifica;

import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input.ListarFacturaReservacionEspecificaInputPort;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output.ListarFacturaReservacionEspecificaOutputPort;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output.ListarFacturasDetalladasOutputPort;
import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CasoUsoListarFacturaReservacionEspecifica implements ListarFacturaReservacionEspecificaInputPort {

    private final ListarFacturaReservacionEspecificaOutputPort listarFacturaReservacionEspecificaOutputPort;

    public CasoUsoListarFacturaReservacionEspecifica(ListarFacturaReservacionEspecificaOutputPort listarFacturaReservacionEspecificaOutputPort) {
        this.listarFacturaReservacionEspecificaOutputPort =  listarFacturaReservacionEspecificaOutputPort;
    }
    @Override
    public DetalleFactura_Hotel obtenerDetalleFacturacionEspecifica(UUID id) {
        return this.listarFacturaReservacionEspecificaOutputPort.obtenerDetalleFacturacionEspecifica(id);
    }
}
