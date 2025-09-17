package com.example.Promociones.promocionesRestaurante.Infraestrucura.Feigns;

import com.example.Promociones.promocionesRestaurante.Infraestrucura.Feigns.DTO.BuscarPlatilloResponseDTO;
import com.example.Promociones.promocionesRestaurante.Infraestrucura.Feigns.DTO.RestauranteDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name ="mcsv-restaurante", url = "http://44.223.54.192:8085")

public interface RestauranteFeign {

    @GetMapping("/platillos/{id}")
    public BuscarPlatilloResponseDTO obtenerPlatillo(@Valid @PathVariable UUID id);

    @GetMapping("/platillos/restaurante/{id}")
    public List<BuscarPlatilloResponseDTO> listarPlatillosRestaurante(@Valid @PathVariable UUID id);

    @GetMapping("/restaurante/{id}")
    public ResponseEntity<RestauranteDTO> listarRestauranteEspecifico(@Valid @PathVariable UUID id);



}
