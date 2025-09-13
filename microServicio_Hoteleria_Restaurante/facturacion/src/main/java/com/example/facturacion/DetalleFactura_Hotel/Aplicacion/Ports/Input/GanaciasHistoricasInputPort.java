package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input;

import com.example.facturacion.DetalleFactura_Hotel.Dominio.ObjetosDeValor.Ganancias;

import java.util.List;

public interface GanaciasHistoricasInputPort {
    List<Ganancias> gananciasHistoricas(Long id);

}
