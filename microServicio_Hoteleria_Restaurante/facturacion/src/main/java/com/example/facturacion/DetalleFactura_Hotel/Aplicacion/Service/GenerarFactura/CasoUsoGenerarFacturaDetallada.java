package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Service.GenerarFactura;

import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input.GenerarFacturaDetalladaInputPort;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output.GenerarFacturaDetalladaOutputPort;
import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;
import com.example.facturacion.DetalleFactura_Hotel.Dominio.ObjetosDeValor.precioPorFacturaHotel;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.DTOS.PromocionDTO;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.DTOS.ReservacionResponseDTO;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.PromocioFeing;
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

    private final PromocioFeing promocioFeing;



    public CasoUsoGenerarFacturaDetallada(GenerarFacturaDetalladaOutputPort generarFacturaDetalladaOutputPort, ReservacionFeing reservacionFeing,
                                          PromocioFeing promocioFeing) {
        this.generarFacturaDetalladaOutputPort = generarFacturaDetalladaOutputPort;
        this.reservacionFeing = reservacionFeing;
        this.promocioFeing = promocioFeing;
    }


    @Override
    public DetalleFactura_Hotel generarDetalleFactura(GenerarFacturaDTO detalleFactura_Hotel) {

        //buscar si esta en espera
        if(!this.reservacionFeing.existeEnEspera(detalleFactura_Hotel.getId_reservacion())) {
            throw new EntityNotFoundException("La reservación no está en espera");
        }

        ReservacionResponseDTO  reservacionDeterminada = this.reservacionFeing.obtenerReservacionEspecifica(detalleFactura_Hotel.getId_reservacion());

        //cambio de estado
        this.reservacionFeing.cambiarEstadoReservacion(reservacionDeterminada.getId(), "PAGADA");

        precioPorFacturaHotel nuevaCantidad = new precioPorFacturaHotel
                (reservacionDeterminada.getHabitacion().getPrecio(),
                        reservacionDeterminada.getFechaEntrada(),
                        reservacionDeterminada.getFechaSalida());
        Double precioFinal =nuevaCantidad.getPrecio();

        // ver si hay alguna promocion

        PromocionDTO promocion = this.promocioFeing.onbtenerPromocionActual(reservacionDeterminada.getHabitacion().getId());

        if (promocion!=null){
            precioFinal-=nuevaCantidad.getPrecio()*promocion.getCantidad_descuento()/100;
        }


        DetalleFactura_Hotel detalleFinal = this.generarFacturaDetalladaOutputPort.GenerarFacturaDetallada(
                new DetalleFactura_Hotel(
                        UUID.randomUUID(),
                        LocalDate.now(),
                        detalleFactura_Hotel.getId_reservacion(),
                        new precioPorFacturaHotel(reservacionDeterminada.getHabitacion().getPrecio(), reservacionDeterminada.getFechaEntrada(), reservacionDeterminada.getFechaSalida())
                ));


        detalleFinal.setPrecio(new precioPorFacturaHotel(precioFinal));


        // comprobar fechas
            return detalleFinal;

    }
}
