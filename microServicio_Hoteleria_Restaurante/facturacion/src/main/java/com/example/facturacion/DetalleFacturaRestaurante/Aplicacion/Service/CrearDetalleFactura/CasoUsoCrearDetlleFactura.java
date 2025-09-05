package com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Service.CrearDetalleFactura;

import com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Input.CrearDetlleFacturaInputPort;
import com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Output.CrearDetlleFacturaOutputPort;
import com.example.facturacion.DetalleFacturaRestaurante.Dominio.DetalleFacturaRestaurante;
import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns.DTO.PlatillosResponseDTO;
import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns.RestauranteFeign;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CasoUsoCrearDetlleFactura implements CrearDetlleFacturaInputPort {


    private final CrearDetlleFacturaOutputPort crearDetlleFacturaOutputPort;
    private final RestauranteFeign restauranteFeign;

    public CasoUsoCrearDetlleFactura(CrearDetlleFacturaOutputPort crearDetlleFacturaOutputPort,
                                     RestauranteFeign restauranteFeign) {
        this.crearDetlleFacturaOutputPort = crearDetlleFacturaOutputPort;
        this.restauranteFeign = restauranteFeign;
    }
    @Override
    public DetalleFacturaRestaurante createDetalleFacturaRestaurante(CrearDetlleFacturaDTO detlleFacturaDTO) {
        List listadoPlatillos = new ArrayList();


        // verificar existencia de platillos
        for (ListadoElementosDTO valores: detlleFacturaDTO.getListadoElementosDTO()) {
            PlatillosResponseDTO nuevoPlatillo = restauranteFeign.obtenerPlatillosEspecifica(valores.getIdPlatillo());
            if (nuevoPlatillo != null) {
                listadoPlatillos.add(nuevoPlatillo);
                System.out.println("aca"+nuevoPlatillo.getNombre());
            } else {
                throw new RuntimeException("No se encontro platillo");
            }

        }

        return null;
    }
}
