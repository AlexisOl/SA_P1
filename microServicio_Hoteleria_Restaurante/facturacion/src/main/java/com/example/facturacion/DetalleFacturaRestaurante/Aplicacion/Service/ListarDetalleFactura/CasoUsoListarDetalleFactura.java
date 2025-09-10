package com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Service.ListarDetalleFactura;

import com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Input.ListarDetallaFacturaRestauranteEspecificaInputPort;
import com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Output.ListarDetallaFacturaRestauranteEspecificaOutputPort;
import com.example.facturacion.DetalleFacturaRestaurante.Dominio.DetalleFacturaRestaurante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CasoUsoListarDetalleFactura implements ListarDetallaFacturaRestauranteEspecificaInputPort {


    private final ListarDetallaFacturaRestauranteEspecificaOutputPort listarDetallaFacturaRestauranteEspecificaOutputPort;


    public CasoUsoListarDetalleFactura(ListarDetallaFacturaRestauranteEspecificaOutputPort listarDetallaFacturaRestauranteEspecificaOutputPort){
        this.listarDetallaFacturaRestauranteEspecificaOutputPort=listarDetallaFacturaRestauranteEspecificaOutputPort;
    }

    @Override
    public List<DetalleFacturaRestaurante> ListarDetalleFactura(UUID id) {
        return this.listarDetallaFacturaRestauranteEspecificaOutputPort.ListarDetalleFactura(id);
    }
}
