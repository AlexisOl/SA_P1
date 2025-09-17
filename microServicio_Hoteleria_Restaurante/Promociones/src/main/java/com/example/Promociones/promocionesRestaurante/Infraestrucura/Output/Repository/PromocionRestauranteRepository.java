package com.example.Promociones.promocionesRestaurante.Infraestrucura.Output.Repository;

import com.example.Promociones.PromocionesHotel.Infraestrucura.Output.Entitty.PromocionHotelEntity;
import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;
import com.example.Promociones.promocionesRestaurante.Infraestrucura.Output.Entitty.PromocionRestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PromocionRestauranteRepository extends JpaRepository<PromocionRestauranteEntity, UUID> {
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END " +
            "FROM PromocionRestauranteEntity p " +
            "WHERE p.platillo = :platillo " +
            "AND (" +
            "   (:fechaInicio BETWEEN p.fechaInicio AND p.fechaFinal) OR " +
            "   (:fechaFinal BETWEEN p.fechaInicio AND p.fechaFinal) OR " +
            "   (p.fechaInicio BETWEEN :fechaInicio AND :fechaFinal) OR " +
            "   (p.fechaFinal BETWEEN :fechaInicio AND :fechaFinal)" +
            ")")
    boolean existsOverlappingPromotion(@Param("platillo") UUID platillo,
                                       @Param("fechaInicio") LocalDate fechaInicio,
                                       @Param("fechaFinal") LocalDate fechaFinal);

    List<PromocionRestauranteEntity> findAllByPlatilloIn(List<UUID> habitacionIds);

    PromocionRestauranteEntity findAllByPlatilloAndFechaFinalBeforeAndFechaInicioBefore(UUID platillo, LocalDate fechaFinalBefore, LocalDate fechaInicioBefore);


    PromocionRestauranteEntity findByPlatilloAndFechaInicioLessThanEqualAndFechaFinalGreaterThanEqual(
            UUID platillo,
            LocalDate fechaInicio,
            LocalDate fechaFinal
    );
}
