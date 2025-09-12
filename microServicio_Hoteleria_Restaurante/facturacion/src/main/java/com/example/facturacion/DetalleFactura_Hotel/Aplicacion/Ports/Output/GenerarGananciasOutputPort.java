package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output;

import com.example.facturacion.DetalleFactura_Hotel.Dominio.ObjetosDeValor.Ganancias;

import java.util.List;
import java.util.UUID;

public interface GenerarGananciasOutputPort {
    List<Object[]> gananciasHistoricas(Long id);

}
