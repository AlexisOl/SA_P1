package com.example.hoteleria.Rerservacion.Aplicacion.Service.CasosUso.ExistenciaHabitacionesEnEspera;

import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Input.ExistenciaReservaHabitacionesEnEsperaInputPort;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.ExistenciaHabitacionesEnEsperaId;
import com.example.hoteleria.Rerservacion.Dominio.TipoReservacion;
import com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.ReservacionPersistenciaAdaptador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ExistenciaHabitaciones implements ExistenciaReservaHabitacionesEnEsperaInputPort {

    private final ReservacionPersistenciaAdaptador  reservacionPersistenciaAdaptador;


    @Override
    public boolean existeReservaEnEspera(UUID id_habitacion, TipoReservacion Estado) {
        return reservacionPersistenciaAdaptador.existenciaHabitacionesEnEsperaId(id_habitacion, Estado);
    }
}
