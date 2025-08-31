package com.example.hoteleria.Habitaciones.Aplicacion.Service.CrearHabitacion;

import com.example.hoteleria.Habitaciones.Aplicacion.ports.Output.CreacionHabitacionOutputPortPersistence;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.CreacionHabitacionInputPort;
import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Output.Persistence.HotelPersistenciaAdaptador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class CasoUsoCrearHabitacion implements CreacionHabitacionInputPort {
    private final HotelPersistenciaAdaptador hotelPersistenciaAdaptador;
    private final CreacionHabitacionOutputPortPersistence creacionHabitacionOutputPortPersistence;


    @Override
    public Habitacion crearHabitacion(CrearHabitacionDTO crearHabitacionDTO) {
        Optional<Hotel> hotel = hotelPersistenciaAdaptador.buscarHotelId(crearHabitacionDTO.getId_hotel());
        Hotel hotelEncontrado = hotel.get();

        Habitacion nuevaHabitacion = this.creacionHabitacionOutputPortPersistence.crearHabitacion(
                new Habitacion(
                        UUID.randomUUID(),
                        crearHabitacionDTO.getNumero_habitacion(),
                        crearHabitacionDTO.getCantidad_camas(),
                        hotelEncontrado,
                        crearHabitacionDTO.getTipoHabitacion(),
                        crearHabitacionDTO.getPrecio()
        ));


        return nuevaHabitacion;
    }
}
