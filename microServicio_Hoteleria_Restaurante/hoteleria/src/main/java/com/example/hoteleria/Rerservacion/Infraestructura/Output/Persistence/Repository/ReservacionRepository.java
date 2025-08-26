package com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Repository;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import com.example.hoteleria.Rerservacion.Infraestructura.Output.Persistence.Entity.ReservacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ReservacionRepository extends JpaRepository<ReservacionEntity, UUID> {
}
