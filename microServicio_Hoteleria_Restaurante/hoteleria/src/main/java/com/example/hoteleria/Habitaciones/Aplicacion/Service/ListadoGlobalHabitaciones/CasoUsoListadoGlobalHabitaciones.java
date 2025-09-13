package com.example.hoteleria.Habitaciones.Aplicacion.Service.ListadoGlobalHabitaciones;

import com.example.hoteleria.Habitaciones.Aplicacion.ports.Output.ListadoGlobalHabitacionesOutputPort;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.ListadoGlobalHabitacionesInputPort;
import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasoUsoListadoGlobalHabitaciones implements ListadoGlobalHabitacionesInputPort {
    private final ListadoGlobalHabitacionesOutputPort listadoGlobalHabitacionesOutputPort;


    public CasoUsoListadoGlobalHabitaciones(ListadoGlobalHabitacionesOutputPort listadoGlobalHabitacionesOutputPort){
        this.listadoGlobalHabitacionesOutputPort=listadoGlobalHabitacionesOutputPort;
    }


    @Override
    public List<Habitacion> listaadoGlobal() {
        return this.listadoGlobalHabitacionesOutputPort.listaadoGlobal();
    }
}
