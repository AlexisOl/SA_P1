package com.example.hoteleria.Habitaciones.Aplicacion.ports.input;

import com.example.hoteleria.Habitaciones.Aplicacion.Service.CrearHabitacion.CrearHabitacionDTO;
import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import jakarta.validation.Valid;

public interface CreacionHabitacionInputPort {

    Habitacion crearHabitacion(@Valid  CrearHabitacionDTO crearHabitacionDTO);
}
