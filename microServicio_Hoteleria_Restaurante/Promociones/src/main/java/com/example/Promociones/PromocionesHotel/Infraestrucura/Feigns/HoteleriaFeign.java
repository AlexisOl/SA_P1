package com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns;

import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.DTO.BuscarHabitacionResponseDTO;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.DTO.HotelDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name ="mcsv-hoteleria", url = "http://44.223.54.192:8081")

public interface HoteleriaFeign {

    @GetMapping("/habitaciones/habitacion/{habitacion_id}")
    public BuscarHabitacionResponseDTO obtenerHabitacion(@Valid @PathVariable UUID habitacion_id);

    @GetMapping("/habitaciones/{hotel_id}")
    public List<BuscarHabitacionResponseDTO> obtenerHabitacionHotel(@Valid @PathVariable Long hotel_id);

    @GetMapping("/hotel/{id}")
    public ResponseEntity<HotelDTO> obtenerHotel(@Valid @PathVariable Long id);

    //obtener habitaciones en un hotel


}
