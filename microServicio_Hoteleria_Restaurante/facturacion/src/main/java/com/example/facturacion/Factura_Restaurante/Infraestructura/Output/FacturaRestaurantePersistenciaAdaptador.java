package com.example.facturacion.Factura_Restaurante.Infraestructura.Output;

import com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Output.CrearFacturaRestauranteOutputPort;
import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;
import com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Mapper.FacturaRestauranteMapper;
import com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Repository.FacturaRestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FacturaRestaurantePersistenciaAdaptador implements CrearFacturaRestauranteOutputPort {

    private final FacturaRestauranteRepository facturaRestauranteRepository;
    private final FacturaRestauranteMapper facturaRestauranteMapper;
    @Override
    public FacturaRestaurante crearFacturaRestaurante(FacturaRestaurante facturaRestaurante) {
        return this.facturaRestauranteMapper.toFacturaRestaurante(
                this.facturaRestauranteRepository.save(
                        this.facturaRestauranteMapper.toFAFacturaRestauranteEntity(facturaRestaurante)
                )
        );
    }
}
