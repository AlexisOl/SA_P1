package com.example.hoteleria.Habitaciones.Aplicacion.Service.ReporteHabitacionMejorPuntuada;

import com.example.hoteleria.Calificacion.Aplicacion.Ports.Output.ObtenerHabitacionConMejorPuntuacionOutputPort;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.Output.BuscarHabitacionOutputPort;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.Output.HabitacionMejorPuntuadaOutputPort;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.BuscarHabitacionInputPort;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.HabitacionMejorPuntuadaInputPort;
import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.DTO.HabitacionConReservacionesDTO;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.ListarResrevacionesPorHabitacionEspecificaOutputPort;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CasoUsoHabitacionMejorPuntuada implements HabitacionMejorPuntuadaInputPort {
    private final HabitacionMejorPuntuadaOutputPort  habitacionMejorPuntuadaOutputPort;
    private final BuscarHabitacionInputPort buscarHabitacionInputPort;
    private final ObtenerHabitacionConMejorPuntuacionOutputPort obtenerHabitacionConMejorPuntuacionOutputPort;
    private final ListarResrevacionesPorHabitacionEspecificaOutputPort  listarResrevacionesPorHabitacionEspecificaOutputPort;


    public CasoUsoHabitacionMejorPuntuada(HabitacionMejorPuntuadaOutputPort  habitacionMejorPuntuadaOutputPort,
                                          ObtenerHabitacionConMejorPuntuacionOutputPort obtenerHabitacionConMejorPuntuacionOutputPort,
                                          ListarResrevacionesPorHabitacionEspecificaOutputPort  listarResrevacionesPorHabitacionEspecificaOutputPort,
                                          BuscarHabitacionInputPort buscarHabitacionInputPort){
        this.habitacionMejorPuntuadaOutputPort=habitacionMejorPuntuadaOutputPort;
        this.listarResrevacionesPorHabitacionEspecificaOutputPort=listarResrevacionesPorHabitacionEspecificaOutputPort;
        this.obtenerHabitacionConMejorPuntuacionOutputPort=obtenerHabitacionConMejorPuntuacionOutputPort;
        this.buscarHabitacionInputPort=buscarHabitacionInputPort;
    }
    @Override
    public Object habitacionMejorPuntuada() {
        UUID id_habitacion =this.obtenerHabitacionConMejorPuntuacionOutputPort.obtenerHabitacionConMejorPuntuacion();

        Habitacion habitacion = this.buscarHabitacionInputPort.buscarHabitacion(id_habitacion);
        if(habitacion==null){
            throw new RuntimeException("Habitacion no encontrada");
        }


        List<Reservacion> reservacionList = this.listarResrevacionesPorHabitacionEspecificaOutputPort.ListarRersvacionesHabitacionesEspecifca(habitacion.getId());



        return this.habitacionMejorPuntuadaOutputPort.habitacionMejorPuntuada(new HabitacionConReservacionesDTO(habitacion, reservacionList));
    }
}
