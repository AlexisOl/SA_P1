package com.example.hoteleria.Rerservacion.Aplicacion.Service.CasosUso.CrearReservacion;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence.HabitacionPersistenciaAdaptador;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Input.CrearReservacionInputPort;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.CrearReservacionOutputPort;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.hayTraslapeOutputPort;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import com.example.hoteleria.Rerservacion.Dominio.TipoReservacion;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CrearReservacion implements CrearReservacionInputPort {

    private final HabitacionPersistenciaAdaptador  habitacionPersistenciaAdaptador;
    private final CrearReservacionOutputPort  crearReservacionOutputPort;
    private final hayTraslapeOutputPort traslapeOutputPort;


    @Override
    public Reservacion crearReservacion(CrearReservacionDTO crearReservacionDTO) {

        Habitacion habitacionEncontrada = this.habitacionPersistenciaAdaptador.buscarHabitacion(crearReservacionDTO.getHabitacion());
        if(habitacionEncontrada==null){
            throw  new RuntimeException("Habitacion no encontrada");
        }

        // QUE NO HAYA TRASLAPE
        if(this.traslapeOutputPort.existeTraslape(habitacionEncontrada.getId(), crearReservacionDTO.getFechaEntrada(), crearReservacionDTO.getFechaSalida())){
            throw new RuntimeException("Ya tiene registrada un evento en ese periodo de tiempo");
        }

        System.out.println(crearReservacionDTO);
        Reservacion nuevaReservacion= this.crearReservacionOutputPort.crearReservacion(
                new Reservacion(
                UUID.randomUUID(),
                crearReservacionDTO.getFechaEntrada(),
                crearReservacionDTO.getFechaSalida(),
                habitacionEncontrada,
                crearReservacionDTO.getIdusuario(),
                        TipoReservacion.valueOf(crearReservacionDTO.getTipoReservacion())
                )
        );
        return nuevaReservacion;
    }
}
