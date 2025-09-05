package com.example.facturacion.Factura_Restaurante.Dominio.ObjetosValor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrecioFactura {
    private Double precioTotal;



    public PrecioFactura(Double precioTotal) {

        this.precioTotal = precioTotal;
    }


}
