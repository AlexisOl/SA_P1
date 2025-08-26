package com.example.hoteleria.Habitaciones.Aplicacion.Service.BuscarHabitacionId;

import com.example.hoteleria.Habitaciones.Aplicacion.ports.Output.BuscarHabitacionOutputPort;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.BuscarHabitacionInputPort;
import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CasoUsoBuscarHabitacionId implements BuscarHabitacionInputPort {

    private final BuscarHabitacionOutputPort buscarHabitacionOutputPort;

    public CasoUsoBuscarHabitacionId(BuscarHabitacionOutputPort buscarHabitacionOutputPort){
        this.buscarHabitacionOutputPort =  buscarHabitacionOutputPort;
    }
    @Override
    public Habitacion buscarHabitacion(UUID habitacion) {

        Habitacion buscarHabitacion = this.buscarHabitacionOutputPort.buscarHabitacion(habitacion);

        return buscarHabitacion;
    }
}
