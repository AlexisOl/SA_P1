package com.example.hoteleria.Habitaciones.Aplicacion.Service.ListarHabitaciones;

import com.example.hoteleria.Habitaciones.Aplicacion.ports.Output.ListarHaitacionesOutputPersistence;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.ListarHabitacionesInputPort;
import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CasoUsoListarHabitacionesPorHotel implements ListarHabitacionesInputPort {


    private final ListarHaitacionesOutputPersistence listarHaitacionesOutputPersistence;

    @Override
    public List<Habitacion> listarHabitaciones(ListarHabitacionesPorHotelDTO  hotelDTO) {
        return this.listarHaitacionesOutputPersistence.listarHabitaciones(hotelDTO.getId_hotel());
    }
}
