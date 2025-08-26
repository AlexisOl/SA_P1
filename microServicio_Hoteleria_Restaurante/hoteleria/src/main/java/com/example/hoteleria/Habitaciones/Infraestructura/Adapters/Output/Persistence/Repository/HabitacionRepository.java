package com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence.Repository;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Output.Persistence.Entity.HabitacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HabitacionRepository extends JpaRepository<HabitacionEntity, UUID> {
    List<HabitacionEntity> findAllByHotel_Id(Long hotelId);
}
