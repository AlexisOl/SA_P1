package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns;

import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.DTOS.PromocionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name ="mcsv-promociones", url = "http://44.223.54.192:8084")

public interface PromocioFeing {

    @GetMapping("/promocionHotel/actualEspecifica/{habitacion_id}")
    PromocionDTO onbtenerPromocionActual(@PathVariable("habitacion_id") UUID habitacion_id);
}
