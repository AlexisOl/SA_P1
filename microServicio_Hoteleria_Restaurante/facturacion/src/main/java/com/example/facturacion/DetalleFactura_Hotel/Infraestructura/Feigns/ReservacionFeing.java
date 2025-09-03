package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns;

import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.DTOS.ReservacionResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(name ="mcsv-hoteleria", url = "http://localhost:8081")
public interface ReservacionFeing {

    @GetMapping("/reservacion/{id}/en-espera")
    Boolean existeEnEspera(@PathVariable("id") UUID id);


    @GetMapping("/reservacion/{id}")
    ReservacionResponseDTO obtenerReservacionEspecifica(@PathVariable("id") UUID id);
}
