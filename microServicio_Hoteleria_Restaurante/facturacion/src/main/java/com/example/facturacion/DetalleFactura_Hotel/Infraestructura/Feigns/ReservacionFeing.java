package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name ="mcsv-hoteleria", url = "http://localhost:8081")
public interface ReservacionFeing {

    @GetMapping("/reservacion/{id}/en-espera")
    Boolean existeEnEspera(@PathVariable("id") UUID id);
}
