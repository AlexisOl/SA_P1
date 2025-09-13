package com.example.facturacion.Factura_Restaurante.Infraestructura.Output;

import com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Output.ActualizarFactura;
import com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Output.CrearFacturaRestauranteOutputPort;
import com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Output.GananciasHistoticasRestauranteOutputPort;
import com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Output.ListarFacturasUsuarioOutputPort;
import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;
import com.example.facturacion.Factura_Restaurante.Infraestructura.DTO.Ganancias;
import com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Mapper.FacturaRestauranteMapper;
import com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Repository.FacturaRestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class FacturaRestaurantePersistenciaAdaptador implements CrearFacturaRestauranteOutputPort, ListarFacturasUsuarioOutputPort, ActualizarFactura,
        GananciasHistoticasRestauranteOutputPort {

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

    @Override
    public List<FacturaRestaurante> listarFacturas(UUID idUsuario) {
        return this.facturaRestauranteMapper.toListFacturaRestaurante(
                this.facturaRestauranteRepository.findAllByCliente(idUsuario)
        );
    }

    @Override
    public FacturaRestaurante actualizar(FacturaRestaurante facturaRestaurante) {
        return this.facturaRestauranteMapper.toFacturaRestaurante(
                this.facturaRestauranteRepository.save(
                        this.facturaRestauranteMapper.toFAFacturaRestauranteEntity(facturaRestaurante)
                )
        );
    }

    @Override
    public List<Object[]> gananciasHistoricas(UUID id) {
        return List.of();
    }
}
