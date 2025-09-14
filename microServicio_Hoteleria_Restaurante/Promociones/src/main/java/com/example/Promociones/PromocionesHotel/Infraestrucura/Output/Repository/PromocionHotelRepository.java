package com.example.Promociones.PromocionesHotel.Infraestrucura.Output.Repository;

import com.example.Promociones.PromocionesHotel.Infraestrucura.Output.Entitty.PromocionHotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface PromocionHotelRepository extends JpaRepository<PromocionHotelEntity, UUID> {

    boolean existsByHabitacionAndFecha_inicioLessThanEqualAndFecha_finalGreaterThanEqual(
            UUID habitacionId,
            LocalDate fechaInicio,
            LocalDate fechaFinal
    );
}
