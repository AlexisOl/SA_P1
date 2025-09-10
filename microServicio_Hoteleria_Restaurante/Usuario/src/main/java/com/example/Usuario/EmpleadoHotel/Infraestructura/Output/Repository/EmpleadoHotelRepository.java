package com.example.Usuario.EmpleadoHotel.Infraestructura.Output.Repository;

import com.example.Usuario.EmpleadoHotel.Infraestructura.Output.Entity.EmpleadoHotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EmpleadoHotelRepository extends JpaRepository<EmpleadoHotelEntity,Integer> {
    EmpleadoHotelEntity findById(UUID id);

    List<EmpleadoHotelEntity> findAllByIdhotel(Long idhotel);
}
