package com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Output;

import com.example.facturacion.Factura_Restaurante.Infraestructura.DTO.Ganancias;

import java.util.List;
import java.util.UUID;

public interface GananciasHistoticasRestauranteOutputPort {
    List<Object[]> gananciasHistoricas(UUID id);

}
