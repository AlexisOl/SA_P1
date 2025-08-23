package com.example.hoteleria.Habitaciones.Aplicacion.ports.Output;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;

import java.util.List;

public interface ListarHaitacionesOutputPersistence {

    List<Habitacion> listarHabitaciones(Long id_hotel);
}
