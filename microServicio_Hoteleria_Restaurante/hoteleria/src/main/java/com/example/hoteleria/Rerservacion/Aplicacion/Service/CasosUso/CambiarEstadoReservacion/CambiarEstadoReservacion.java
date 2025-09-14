package com.example.hoteleria.Rerservacion.Aplicacion.Service.CasosUso.CambiarEstadoReservacion;

import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Input.CambiarEstadoReservacionInputPort;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.CambiarEstadoReservacionOutputPort;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.ListarReservacionEspecificaOutput;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import com.example.hoteleria.Rerservacion.Dominio.TipoReservacion;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CambiarEstadoReservacion implements CambiarEstadoReservacionInputPort {

    private  final CambiarEstadoReservacionOutputPort cambiarEstadoReservacionOutputPort;
    private final ListarReservacionEspecificaOutput listarReservacionEspecificaOutput;

    public CambiarEstadoReservacion(CambiarEstadoReservacionOutputPort cambiarEstadoReservacionOutputPort,
                                    ListarReservacionEspecificaOutput listarReservacionEspecificaOutput) {
        this.cambiarEstadoReservacionOutputPort = cambiarEstadoReservacionOutputPort;
        this.listarReservacionEspecificaOutput = listarReservacionEspecificaOutput;

    }

    @Override
    public Reservacion cambioEstado(UUID id, String estado) throws RuntimeException {
        //busqueda de la reservacion

        Reservacion reservacion = this.listarReservacionEspecificaOutput.ListarReservacionEspecifica(id);
                if (reservacion == null) {
                    throw  new RuntimeException("No existe la reservacion");
                }
        reservacion.setTipoReservacion(TipoReservacion.valueOf(estado));
        return this.cambiarEstadoReservacionOutputPort.cambiarEstadoReservacion(
                reservacion

        );
    }
}
