package com.example.hoteleria.Habitaciones.Aplicacion.Service.ReporteHabitacionMasAlojamientos;

import com.example.hoteleria.Habitaciones.Aplicacion.ports.Output.HabitacionConMasAlojamientosOutputPort;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.HabitacionConMasAlojamientosInputPort;
import org.springframework.stereotype.Service;

@Service

public class CasoUsoHabitacionMasAlojamientos implements HabitacionConMasAlojamientosInputPort {


    private final HabitacionConMasAlojamientosOutputPort habitacionConMasAlojamientosOutputPort;


    public CasoUsoHabitacionMasAlojamientos(HabitacionConMasAlojamientosOutputPort habitacionConMasAlojamientosOutputPort){
        this.habitacionConMasAlojamientosOutputPort=habitacionConMasAlojamientosOutputPort;
    }
    @Override
    public Object habitacionConMasAlojamientos() {
        return null;
    }
}
