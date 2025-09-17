package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns;

import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns.DTO.PromocionRestauranteDTO;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.DTOS.PromocionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name ="mcsv-promociones-restaurante", url = "http://44.223.54.192:8084")

public interface PromocionRestauranteFeing {

    @GetMapping("/promocionRestaurante/actualEspecifica/{id}")
    PromocionRestauranteDTO onbtenerPromocionActual(@PathVariable("id") UUID id);
}
