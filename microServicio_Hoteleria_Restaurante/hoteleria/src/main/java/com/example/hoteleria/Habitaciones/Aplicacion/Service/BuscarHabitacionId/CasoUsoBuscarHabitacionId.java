package com.example.hoteleria.Habitaciones.Aplicacion.Service.BuscarHabitacionId;

import com.example.hoteleria.Habitaciones.Aplicacion.Factory.HabitacionFactory;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.Output.BuscarHabitacionOutputPort;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.BuscarHabitacionInputPort;
import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CasoUsoBuscarHabitacionId implements BuscarHabitacionInputPort {

    private final BuscarHabitacionOutputPort buscarHabitacionOutputPort;
    private final HabitacionFactory habitacionFactory;

    public CasoUsoBuscarHabitacionId(BuscarHabitacionOutputPort buscarHabitacionOutputPort, HabitacionFactory habitacionFactory){
        this.buscarHabitacionOutputPort =  buscarHabitacionOutputPort;
        this.habitacionFactory = habitacionFactory;
    }
    @Override
    public Habitacion buscarHabitacion(UUID habitacion) {

        Habitacion buscarHabitacion = this.buscarHabitacionOutputPort.buscarHabitacion(habitacion);

        System.out.println(habitacionFactory.createHabitacionConPuntuacion(buscarHabitacion).getPromedio_valoracion()+"aca"+
                habitacionFactory.createHabitacionConPuntuacion(buscarHabitacion).getPrecio());
        return habitacionFactory.createHabitacionConPuntuacion(buscarHabitacion);
    }
}
