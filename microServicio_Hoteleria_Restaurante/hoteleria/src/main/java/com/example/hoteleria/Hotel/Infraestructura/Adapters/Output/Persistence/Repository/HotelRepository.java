package com.example.hoteleria.Hotel.Infraestructura.Adapters.Output.Persistence.Repository;

import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Output.Persistence.Entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    HotelEntity findHotelEntityById(Long hotelId);
}
