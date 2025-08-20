package com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence;

import com.example.hoteleria.Habitaciones.Aplicacion.Service.CrearHabitacion.CrearHabitacionDTO;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.Output.CreacionHabitacionOutputPortPersistence;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.CreacionHabitacionInputPort;
import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence.Mapper.HabitacionMapper;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence.Repository.HabitacionRepository;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Output.Persistence.HotelPersistenciaAdaptador;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HabitacionPersistenciaAdaptador implements CreacionHabitacionOutputPortPersistence {

    private final HabitacionRepository habitacionRepository;
    private final HabitacionMapper habitacionMapper;




    @Override
    @Transactional
    public Habitacion crearHabitacion(Habitacion habitacion) {
        return habitacionMapper.toHabitacion(
                habitacionRepository.save(
                        habitacionMapper.toHabitacionEntity((habitacion)))
        );
    }
}
