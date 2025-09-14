package com.example.hoteleria.Habitaciones.Aplicacion.Service.ReporteHabitacionMasAlojamientos;

import com.example.hoteleria.Calificacion.Aplicacion.Ports.Output.ObtenerHabitacionConMejorPuntuacionOutputPort;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.Output.HabitacionConMasAlojamientosOutputPort;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.BuscarHabitacionInputPort;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.HabitacionConMasAlojamientosInputPort;
import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.DTO.HabitacionConReservacionesDTO;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.IDHabitacionConMasReservacionesOutputPort;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.ListarResrevacionesPorHabitacionEspecificaOutputPort;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class CasoUsoHabitacionMasAlojamientos implements HabitacionConMasAlojamientosInputPort {


    private final HabitacionConMasAlojamientosOutputPort habitacionConMasAlojamientosOutputPort;
    private final BuscarHabitacionInputPort buscarHabitacionInputPort;
    private final IDHabitacionConMasReservacionesOutputPort idHabitacionConMasReservacionesOutputPort;
    private final ListarResrevacionesPorHabitacionEspecificaOutputPort listarResrevacionesPorHabitacionEspecificaOutputPort;



    public CasoUsoHabitacionMasAlojamientos(HabitacionConMasAlojamientosOutputPort habitacionConMasAlojamientosOutputPort,
                                            BuscarHabitacionInputPort buscarHabitacionInputPort,
                                            IDHabitacionConMasReservacionesOutputPort idHabitacionConMasReservacionesOutputPort,
                                            ListarResrevacionesPorHabitacionEspecificaOutputPort listarResrevacionesPorHabitacionEspecificaOutputPort){
        this.habitacionConMasAlojamientosOutputPort=habitacionConMasAlojamientosOutputPort;
        this.idHabitacionConMasReservacionesOutputPort=idHabitacionConMasReservacionesOutputPort;
        this.listarResrevacionesPorHabitacionEspecificaOutputPort=listarResrevacionesPorHabitacionEspecificaOutputPort;
        this.buscarHabitacionInputPort=buscarHabitacionInputPort;
    }
    @Override
    public Object habitacionConMasAlojamientos() {
        UUID id_habitacion =this.idHabitacionConMasReservacionesOutputPort.obtenerHabitacionConMasAlojamientos();

        Habitacion habitacion = this.buscarHabitacionInputPort.buscarHabitacion(id_habitacion);
        if(habitacion==null){
            throw new RuntimeException("Habitacion no encontrada");
        }


        List<Reservacion> reservacionList = this.listarResrevacionesPorHabitacionEspecificaOutputPort.ListarRersvacionesHabitacionesEspecifca(habitacion.getId());



        return this.habitacionConMasAlojamientosOutputPort.habitacionConMasAlojamientos(new HabitacionConReservacionesDTO(habitacion, reservacionList));
    }
}
