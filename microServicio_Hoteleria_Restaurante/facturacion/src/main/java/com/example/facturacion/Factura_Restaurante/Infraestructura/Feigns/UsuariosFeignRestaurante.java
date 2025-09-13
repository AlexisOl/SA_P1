package com.example.facturacion.Factura_Restaurante.Infraestructura.Feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name ="mcsv-usuarios-restaurante", url = "http://44.223.54.192:8082")

public interface UsuariosFeignRestaurante {

    @GetMapping("/empleadoRestaurante/pagos/{id}")
    List<Object[]> pagosEmpleado(@PathVariable("id") UUID id);
}
