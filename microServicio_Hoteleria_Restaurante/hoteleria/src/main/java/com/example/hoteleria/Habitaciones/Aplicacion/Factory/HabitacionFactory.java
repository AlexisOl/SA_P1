package com.example.hoteleria.Habitaciones.Aplicacion.Factory;

import com.example.hoteleria.Calificacion.Aplicacion.Ports.Output.PromedioValoracionHabitacion;
import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class HabitacionFactory {

    private final PromedioValoracionHabitacion promedioValoracionHabitacion;

    @Autowired
    public HabitacionFactory(PromedioValoracionHabitacion promedioValoracionHabitacion) {
        this.promedioValoracionHabitacion = promedioValoracionHabitacion;
    }


    public Habitacion createHabitacionConPuntuacion(Habitacion habitacion) {
        double puntuacion = promedioValoracionHabitacion.promedioValoracion(habitacion.getId());


        return new Habitacion(
                habitacion.getId(),
                habitacion.getNumero_habitacion(),
                habitacion.getCantidad_camas(),
                habitacion.getHotel(),
                habitacion.getTipoHabitacion(),
                habitacion.getPrecio(),
                puntuacion);
    }



}
