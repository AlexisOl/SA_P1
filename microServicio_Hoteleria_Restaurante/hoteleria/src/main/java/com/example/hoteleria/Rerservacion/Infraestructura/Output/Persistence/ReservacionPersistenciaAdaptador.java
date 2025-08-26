package com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence;

import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.CrearReservacionOutputPort;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Mapper.ReservacionMapper;
import com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Repository.ReservacionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReservacionPersistenciaAdaptador implements CrearReservacionOutputPort {

    private final ReservacionMapper reservacionMapper;
    private final ReservacionRepository reservacionRepository;


    @Override
    @Transactional
    public Reservacion crearReservacion(Reservacion reservacion) {
        return this.reservacionMapper.toReservacion(
                this.reservacionRepository.save(
                        this.reservacionMapper.toReservacionEntity(reservacion)
                )
        );
    }
}
