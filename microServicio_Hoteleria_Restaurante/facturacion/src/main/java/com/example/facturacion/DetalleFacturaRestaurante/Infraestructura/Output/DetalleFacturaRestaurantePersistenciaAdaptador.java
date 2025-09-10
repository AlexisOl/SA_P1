package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Output;


import com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Output.CrearDetlleFacturaOutputPort;
import com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Output.ListarDetallaFacturaRestauranteEspecificaOutputPort;
import com.example.facturacion.DetalleFacturaRestaurante.Dominio.DetalleFacturaRestaurante;
import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Output.Mapper.DetalleFacturaRestauranteMapper;
import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Output.Repository.DetalleFacturaRestauranteRepository;
import com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Output.CrearFacturaRestauranteOutputPort;
import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DetalleFacturaRestaurantePersistenciaAdaptador implements CrearDetlleFacturaOutputPort, ListarDetallaFacturaRestauranteEspecificaOutputPort {

    private final DetalleFacturaRestauranteMapper detalleFacturaRestauranteMapper;

    private final DetalleFacturaRestauranteRepository  detalleFacturaRestauranteRepository;



    @Override
    @Transactional

    public DetalleFacturaRestaurante createDetalleFacturaRestaurante(DetalleFacturaRestaurante detalleFacturaRestaurante) {
                return this.detalleFacturaRestauranteMapper.toFacturaRestaurante(
                this.detalleFacturaRestauranteRepository.save(
                        this.detalleFacturaRestauranteMapper.toDetalleFacturaEntity(detalleFacturaRestaurante)
                )
        );
    }

    @Override
    public List<DetalleFacturaRestaurante> ListarDetalleFactura(UUID id) {
        return this.detalleFacturaRestauranteMapper.toListFacturaRestaurante(
                this.detalleFacturaRestauranteRepository.findAllByFacturaRestaurante_Id((id)
        ));
    }
}
