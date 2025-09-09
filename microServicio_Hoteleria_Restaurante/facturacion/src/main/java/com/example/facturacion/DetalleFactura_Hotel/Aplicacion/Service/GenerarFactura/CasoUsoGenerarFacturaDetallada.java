package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Service.GenerarFactura;

import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input.GenerarFacturaDetalladaInputPort;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output.GenerarFacturaDetalladaOutputPort;
import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;
import com.example.facturacion.DetalleFactura_Hotel.Dominio.ObjetosDeValor.precioPorFacturaHotel;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.DTOS.ReservacionResponseDTO;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.ReservacionFeing;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
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
        if(!this.reservacionFeing.existeEnEspera(detalleFactura_Hotel.getId_reservacion())) {
            throw new EntityNotFoundException("La reservación no está en espera");
        }

        ReservacionResponseDTO  reservacionDeterminada = this.reservacionFeing.obtenerReservacionEspecifica(detalleFactura_Hotel.getId_reservacion());

        // comprobar fechas
        System.out.println(reservacionDeterminada.getHabitacion().getPrecio() + " ---"+reservacionDeterminada.getFechaEntrada()+ " ---"+ reservacionDeterminada.getFechaSalida());
        System.out.println(detalleFactura_Hotel);
            return this.generarFacturaDetalladaOutputPort.GenerarFacturaDetallada(
                    new DetalleFactura_Hotel(
                            UUID.randomUUID(),
                            LocalDate.now(),
                            detalleFactura_Hotel.getId_reservacion(),
                            new precioPorFacturaHotel(reservacionDeterminada.getHabitacion().getPrecio(), reservacionDeterminada.getFechaEntrada(), reservacionDeterminada.getFechaSalida())
                            )
            );

    }
}
