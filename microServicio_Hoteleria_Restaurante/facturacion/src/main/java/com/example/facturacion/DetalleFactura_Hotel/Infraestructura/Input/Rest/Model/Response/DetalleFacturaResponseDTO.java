package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Input.Rest.Model.Response;

import com.example.facturacion.DetalleFactura_Hotel.Dominio.ObjetosDeValor.precioPorFacturaHotel;
import com.example.facturacion.Factura_Restaurante.Dominio.ObjetosValor.PrecioFactura;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class DetalleFacturaResponseDTO {
    private final UUID id;
    private final LocalDate fecha;
    private UUID id_reservacion;
    private precioPorFacturaHotel precio;
}
