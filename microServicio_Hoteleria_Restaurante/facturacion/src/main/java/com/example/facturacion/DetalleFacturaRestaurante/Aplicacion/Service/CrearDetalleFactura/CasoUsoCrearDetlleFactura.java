package com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Service.CrearDetalleFactura;

import com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Input.CrearDetlleFacturaInputPort;
import com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Output.CrearDetlleFacturaOutputPort;
import com.example.facturacion.DetalleFacturaRestaurante.Dominio.DetalleFacturaRestaurante;
import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns.DTO.PlatillosResponseDTO;
import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns.DTO.PromocionRestauranteDTO;
import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns.PromocionRestauranteFeing;
import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns.RestauranteFeign;
import com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Output.ActualizarFactura;
import com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Output.CrearFacturaRestauranteOutputPort;
import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;
import com.example.facturacion.Factura_Restaurante.Dominio.ObjetosValor.PrecioFactura;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CasoUsoCrearDetlleFactura implements CrearDetlleFacturaInputPort {


    private final CrearDetlleFacturaOutputPort crearDetlleFacturaOutputPort;
    private final CrearFacturaRestauranteOutputPort crearFacturaRestauranteOutputPort;
    private final RestauranteFeign restauranteFeign;
    private final ActualizarFactura actualizarFactura;
    private final PromocionRestauranteFeing promocionRestauranteFeing;

    public CasoUsoCrearDetlleFactura(CrearDetlleFacturaOutputPort crearDetlleFacturaOutputPort,
                                     RestauranteFeign restauranteFeign,
                                     CrearFacturaRestauranteOutputPort crearFacturaRestauranteOutputPort,
                                     ActualizarFactura actualizarFactura,
                                     PromocionRestauranteFeing promocionRestauranteFeing) {
        this.crearDetlleFacturaOutputPort = crearDetlleFacturaOutputPort;
        this.restauranteFeign = restauranteFeign;
        this.crearFacturaRestauranteOutputPort = crearFacturaRestauranteOutputPort;
        this.actualizarFactura=actualizarFactura;
        this.promocionRestauranteFeing=promocionRestauranteFeing;
    }
    @Override
    public DetalleFacturaRestaurante createDetalleFacturaRestaurante(CrearDetlleFacturaDTO detlleFacturaDTO) {
        List listadoPlatillos = new ArrayList();
        double precioTotal = 0.0;
        HashMap<PlatillosResponseDTO, Long> platillosFinal = new HashMap<>();


        // verificar existencia de platillos
        for (ListadoElementosDTO valores: detlleFacturaDTO.getListadoElementosDTO()) {
            PlatillosResponseDTO nuevoPlatillo = restauranteFeign.obtenerPlatillosEspecifica(valores.getIdPlatillo());
            if (nuevoPlatillo != null) {
                platillosFinal.put(nuevoPlatillo, valores.getCantidad());
                System.out.println("aca"+platillosFinal.get(nuevoPlatillo));
            } else {
                throw new RuntimeException("No se encontro platillo");
            }
        }

        // crear objeto

        FacturaRestaurante nuevaFacturaRestaurante = this.crearFacturaRestauranteOutputPort.crearFacturaRestaurante(
                new FacturaRestaurante(
                  UUID.randomUUID(),
                        detlleFacturaDTO.getFecha(),
                        detlleFacturaDTO.getIdCliente()
                )
        );

        for (Map.Entry<PlatillosResponseDTO, Long>  platillosEspecifico: platillosFinal.entrySet()) {
            PlatillosResponseDTO platillo = platillosEspecifico.getKey();
            Long cantidad = platillosEspecifico.getValue();

            System.out.println("Platillo: " + platillo.getNombre() + " - Cantidad: " + cantidad);

            Double precioParcial = platillosEspecifico.getValue()*platillosEspecifico.getKey().getPrecio();
            PromocionRestauranteDTO Descuento = this.promocionRestauranteFeing.onbtenerPromocionActual(platillosEspecifico.getKey().getId());

            if (Descuento!=null){
                precioParcial -= platillosEspecifico.getValue()*platillosEspecifico.getKey().getPrecio()*Descuento.getCantidad_descuento()/100;
            }

            this.crearDetlleFacturaOutputPort.createDetalleFacturaRestaurante(
                    new DetalleFacturaRestaurante(
                            UUID.randomUUID(),
                            platillosEspecifico.getKey().getId(),
                            platillosEspecifico.getValue(),
                            precioParcial,
                            nuevaFacturaRestaurante
                    )
            );

            precioTotal+=platillosEspecifico.getValue()*platillosEspecifico.getKey().getPrecio();

        }


    // todo bien actualiza el precio
        nuevaFacturaRestaurante.setPrecioTotal(new PrecioFactura(precioTotal));
        this.actualizarFactura.actualizar(nuevaFacturaRestaurante);
        return null;
    }
}
