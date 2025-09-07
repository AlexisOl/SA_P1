package com.example.hoteleria.Calificacion.Infraestructura.Output.Repository;

import com.example.hoteleria.Calificacion.Infraestructura.Output.Entity.CalificacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CalificacionRepository extends JpaRepository<CalificacionEntity, UUID> {

    @Query("SELECT COALESCE(AVG(c.puntuacion), 0)  FROM CalificacionEntity c WHERE c.reservacion.habitacion.id = :id_habitacion")
    Double calcularPromedioValoracionHabitacion(UUID id_habitacion);


    List<CalificacionEntity> findAllByReservacion_Habitacion_Id(UUID reservacionHabitacionId);

}
