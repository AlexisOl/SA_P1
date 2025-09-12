package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input;

import java.util.List;
import java.util.UUID;

public interface GenerarGananciasInputPort {

    List<Object[]> gananciasHistoricas(Long id);
}
