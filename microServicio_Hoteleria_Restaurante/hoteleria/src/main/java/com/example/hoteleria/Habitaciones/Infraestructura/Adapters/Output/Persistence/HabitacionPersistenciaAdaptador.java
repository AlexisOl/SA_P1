package com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence;

import com.example.hoteleria.Habitaciones.Aplicacion.Service.BuscarHabitacionId.CasoUsoBuscarHabitacionId;
import com.example.hoteleria.Habitaciones.Aplicacion.Service.CrearHabitacion.CrearHabitacionDTO;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.Output.*;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.CreacionHabitacionInputPort;
import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.DTO.HabitacionConReservacionesDTO;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence.Mapper.HabitacionMapper;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence.Repository.HabitacionRepository;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Output.Persistence.HotelPersistenciaAdaptador;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Output.Persistence.Repository.HotelRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class HabitacionPersistenciaAdaptador implements CreacionHabitacionOutputPortPersistence, ListarHaitacionesOutputPersistence ,
        BuscarHabitacionOutputPort , HabitacionMejorPuntuadaOutputPort, HabitacionConMasAlojamientosOutputPort {

    private final HabitacionRepository habitacionRepository;
    private final HotelRepository hotelRepository;
    private final HabitacionMapper habitacionMapper;




    @Override
    @Transactional
    public Habitacion crearHabitacion(Habitacion habitacion) {
        return habitacionMapper.toHabitacion(
                habitacionRepository.save(
                        habitacionMapper.toHabitacionEntity((habitacion)))
        );
    }

    @Override
    public List<Habitacion> listarHabitaciones(Long id_hotel) {
        return habitacionMapper.toHabitacionList(this.habitacionRepository.findAllByHotel_Id(id_hotel)) ;
    }

    @Override
    @Transactional
    public Habitacion buscarHabitacion(UUID id_habitacion) {
        return habitacionRepository.findById(id_habitacion)
                .map(habitacionMapper::toHabitacion)
                .orElse(null);
    }

    @Override
    public Object habitacionConMasAlojamientos(HabitacionConReservacionesDTO habitacion) {
        return habitacion;
    }

    @Override
    public Object habitacionMejorPuntuada(HabitacionConReservacionesDTO habitacion) {
        return habitacion;
    }
}
