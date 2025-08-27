package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Service.GenerarFactura;

import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input.GenerarFacturaDetalladaInputPort;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output.GenerarFacturaDetalladaOutputPort;
import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.ReservacionFeing;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CasoUsoGenerarFacturaDetallada implements GenerarFacturaDetalladaInputPort {

    private final GenerarFacturaDetalladaOutputPort generarFacturaDetalladaOutputPort;

    private final ReservacionFeing reservacionFeing;



    public CasoUsoGenerarFacturaDetallada(GenerarFacturaDetalladaOutputPort generarFacturaDetalladaOutputPort, ReservacionFeing reservacionFeing) {
        this.generarFacturaDetalladaOutputPort = generarFacturaDetalladaOutputPort;
        this.reservacionFeing = reservacionFeing;
    }


    @Override
    public DetalleFactura_Hotel generarDetalleFactura(GenerarFacturaDTO detalleFactura_Hotel) {

        //buscar si esta en espera
        // comprobar fechas
        System.out.println(detalleFactura_Hotel);
        if(this.reservacionFeing.existeEnEspera(detalleFactura_Hotel.getId_reservacion())){
            return this.generarFacturaDetalladaOutputPort.GenerarFacturaDetallada(
                    new DetalleFactura_Hotel(
                            UUID.randomUUID(),
                            detalleFactura_Hotel.getFecha(),
                            detalleFactura_Hotel.getId_reservacion()
                            )
            );
        }
        return null;

    }
}
