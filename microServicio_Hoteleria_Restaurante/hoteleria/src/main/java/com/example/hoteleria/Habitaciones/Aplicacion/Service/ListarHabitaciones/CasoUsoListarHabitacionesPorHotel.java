package com.example.hoteleria.Habitaciones.Aplicacion.Service.ListarHabitaciones;

import com.example.hoteleria.Habitaciones.Aplicacion.Factory.HabitacionFactory;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.Output.ListarHaitacionesOutputPersistence;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.ListarHabitacionesInputPort;
import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence.Repository.HabitacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CasoUsoListarHabitacionesPorHotel implements ListarHabitacionesInputPort {


    private final ListarHaitacionesOutputPersistence listarHaitacionesOutputPersistence;
    private final HabitacionFactory habitacionFactory;

    @Override
    public List<Habitacion> listarHabitaciones(ListarHabitacionesPorHotelDTO  hotelDTO) {
        return this.listarHaitacionesOutputPersistence.listarHabitaciones(hotelDTO.getId_hotel())
                .stream()
                .map(
                        habitacion -> habitacionFactory.createHabitacionConPuntuacion(habitacion)
                ).toList();
    }
}
