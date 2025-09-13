package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output;

import com.example.facturacion.DetalleFactura_Hotel.Dominio.ObjetosDeValor.Ganancias;

import java.util.List;

public interface GananciasHistorciasOutputPort {
    List<Ganancias> gananciasHistoricasHotel(Long id);

}
