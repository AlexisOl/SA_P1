package com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns;

import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.DTO.BuscarHabitacionResponseDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name ="mcsv-hoteleria", url = "http://localhost:8085")

public interface HoteleriaFeign {

    @GetMapping("/habitacion/{habitacion_id}")
    public BuscarHabitacionResponseDTO obtenerHabitacion(@Valid @PathVariable UUID habitacion_id);

}
