package com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Repository;

import com.example.hoteleria.Rerservacion.Dominio.TipoReservacion;
import com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Entity.ReservacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservacionRepository extends JpaRepository<ReservacionEntity, UUID> {

     boolean existsByIdAndTipoReservacion(UUID id, TipoReservacion Estado);

   //  List<Reservacion> findAllByHabitacion_Hotel_Id(UUID hotel_id);

     List<ReservacionEntity> findAllByIdusuario(UUID idUsuario);

     Optional<ReservacionEntity> findById(UUID id);

     List<ReservacionEntity> findAllByHabitacion_Hotel_Id(Long habitacionHotelId);


     List<ReservacionEntity> findAllByHabitacion_Id(UUID habitacionId);

     @Query("""
    SELECT r.habitacion.id
    FROM ReservacionEntity r
    GROUP BY r.habitacion.id
    ORDER BY count(r.habitacion.id) DESC
    LIMIT  1
""")
     UUID  habitacionConMasAlojamientos();



    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END " +
            "FROM ReservacionEntity p " +
            "WHERE p.habitacion.id = :habitacion " +
            "AND (" +
            "   (:fechaInicio BETWEEN p.fechaEntrada AND p.fechaSalida) OR " +
            "   (:fechaFinal BETWEEN p.fechaEntrada AND p.fechaSalida) OR " +
            "   (p.fechaEntrada BETWEEN :fechaInicio AND :fechaFinal) OR " +
            "   (p.fechaSalida BETWEEN :fechaInicio AND :fechaFinal)" +
            ")")
    boolean existsOverlappingPromotion(@Param("habitacion") UUID habitacion,
                                       @Param("fechaInicio") LocalDate fechaInicio,
                                       @Param("fechaFinal") LocalDate fechaFinal);


}
