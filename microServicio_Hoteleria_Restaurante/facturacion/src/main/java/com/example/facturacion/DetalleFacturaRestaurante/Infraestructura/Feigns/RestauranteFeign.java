package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns;

import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns.DTO.PlatillosResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name ="mcsv-restaurante", url = "http://localhost:8085")

public interface RestauranteFeign {

    @GetMapping("/platillos/{id}")
    PlatillosResponseDTO obtenerPlatillosEspecifica(@PathVariable("id") UUID id);
}
