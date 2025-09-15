package com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence;

import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.*;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import com.example.hoteleria.Rerservacion.Dominio.TipoReservacion;
import com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Mapper.ReservacionMapper;
import com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Repository.ReservacionRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ReservacionPersistenciaAdaptador implements CrearReservacionOutputPort, ExistenciaHabitacionesEnEsperaId,
        ListarReservacionesUsuarioOutputPort, ListarReservacionEspecificaOutput, ListarReservacionesHotelOutputPort,
        CambiarEstadoReservacionOutputPort, ListarResrevacionesPorHabitacionEspecificaOutputPort,hayTraslapeOutputPort,
IDHabitacionConMasReservacionesOutputPort{

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

    @Override
    @Transactional(readOnly = true)
    public boolean existenciaHabitacionesEnEsperaId(UUID id_habitacion, TipoReservacion Estado) {
        return this.reservacionRepository.existsByIdAndTipoReservacion(id_habitacion, Estado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservacion> listarReservacionesUsuario(UUID id_usuario) {
        return
                this.reservacionMapper.toReservacionList(reservacionRepository.findAllByIdusuario(id_usuario)) ;
    }

    @Override
    @Transactional(readOnly = true)
    public Reservacion ListarReservacionEspecifica(UUID id) {
        return this.reservacionMapper.toReservacion(this.reservacionRepository.findById(id).get());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservacion> listarReservacionesHotel(Long id) {
        System.out.println(reservacionRepository.findAllByHabitacion_Hotel_Id((id)).get(1).getTipoReservacion());
        return   this.reservacionMapper.toReservacionList(reservacionRepository.findAllByHabitacion_Hotel_Id((id))) ;
    }

    @Override
    public Reservacion cambiarEstadoReservacion(Reservacion reservacion) {
        return this.reservacionMapper.toReservacion(
                this.reservacionRepository.save(reservacionMapper.toReservacionEntity(reservacion))
        );
    }

    @Override
    public List<Reservacion> ListarRersvacionesHabitacionesEspecifca(UUID id) {
        return this.reservacionMapper.toReservacionList(
                this.reservacionRepository.findAllByHabitacion_Id((id)
        ));
    }

    @Override
    public UUID obtenerHabitacionConMasAlojamientos() {
        return this.reservacionRepository.habitacionConMasAlojamientos();
    }

    @Override
    public boolean existeTraslape(UUID habitacion, LocalDate fechaInicio, LocalDate fechaFinal) {
        return this.reservacionRepository.existsOverlappingPromotion(habitacion, fechaInicio, fechaFinal);
    }
}
