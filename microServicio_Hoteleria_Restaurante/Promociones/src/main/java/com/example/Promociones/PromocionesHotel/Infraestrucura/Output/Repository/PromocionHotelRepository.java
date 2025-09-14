package com.example.Promociones.PromocionesHotel.Infraestrucura.Output.Repository;

import com.example.Promociones.PromocionesHotel.Infraestrucura.Output.Entitty.PromocionHotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.UUID;

public interface PromocionHotelRepository extends JpaRepository<PromocionHotelEntity, UUID> {

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END " +
            "FROM PromocionHotelEntity p " +
            "WHERE p.habitacion = :habitacion " +
            "AND (" +
            "   (:fechaInicio BETWEEN p.fechaInicio AND p.fechaFinal) OR " +
            "   (:fechaFinal BETWEEN p.fechaInicio AND p.fechaFinal) OR " +
            "   (p.fechaInicio BETWEEN :fechaInicio AND :fechaFinal) OR " +
            "   (p.fechaFinal BETWEEN :fechaInicio AND :fechaFinal)" +
            ")")
    boolean existsOverlappingPromotion(@Param("habitacion") UUID habitacion,
                                       @Param("fechaInicio") LocalDate fechaInicio,
                                       @Param("fechaFinal") LocalDate fechaFinal);

}
