package com.example.hoteleria.Calificacion.Aplicacion.Service.CasosUso.CrearCalificacionCasoUso;

import com.example.hoteleria.Calificacion.Aplicacion.Ports.Input.CrearCalificacionInputPort;
import com.example.hoteleria.Calificacion.Aplicacion.Ports.Output.CrearCalificacionOutputPort;
import com.example.hoteleria.Calificacion.Dominio.Calificacion;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.ListarReservacionEspecificaOutput;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CrearCalificacion implements CrearCalificacionInputPort {
    private final CrearCalificacionOutputPort crearCalificacionOutputPort;
    private final ListarReservacionEspecificaOutput listarReservacionEspecificaOutput;


    public CrearCalificacion(CrearCalificacionOutputPort crearCalificacionOutputPort, ListarReservacionEspecificaOutput listarReservacionEspecificaOutput){
        this.crearCalificacionOutputPort = crearCalificacionOutputPort;
        this.listarReservacionEspecificaOutput = listarReservacionEspecificaOutput;
    }
    @Override
    public Calificacion crearCalificacion(CrearCalificacionDTO crearCalificacionDTO) {

        // verificacion de existencia de reserva
        Reservacion nuevaReservacion= this.listarReservacionEspecificaOutput.ListarReservacionEspecifica(crearCalificacionDTO.getReservacion());

        return this.crearCalificacionOutputPort.crearCalificacion(
                new Calificacion(
                    UUID.randomUUID(),
                        crearCalificacionDTO.getComentario(),
                        crearCalificacionDTO.getPuntuacion(),
                        nuevaReservacion
                )
        );
    }
}
