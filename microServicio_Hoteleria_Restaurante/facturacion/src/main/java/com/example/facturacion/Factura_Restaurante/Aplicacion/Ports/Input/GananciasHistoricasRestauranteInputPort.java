package com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Input;

import com.example.facturacion.Factura_Restaurante.Infraestructura.DTO.Ganancias;

import java.util.List;
import java.util.UUID;

public interface GananciasHistoricasRestauranteInputPort {
    List<Ganancias> gananciasHistoricas(UUID id);

}
