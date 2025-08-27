package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output;

import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output.GenerarFacturaDetalladaOutputPort;
import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Mapper.DetalleFacturaMapper;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Repository.DetalleFacturaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@AllArgsConstructor
public class DetalleFacturaPersitenciaAdapatador implements GenerarFacturaDetalladaOutputPort {

    private final DetalleFacturaRepository detalleFacturaRepository;
    private final DetalleFacturaMapper detalleFacturaMapper;
    @Override
    @Transactional
    public DetalleFactura_Hotel GenerarFacturaDetallada(DetalleFactura_Hotel detalleFactura_Hotel) {
        System.out.println(detalleFactura_Hotel.getId()+" --- " + detalleFactura_Hotel.getFecha()+" --- " + detalleFactura_Hotel.getId_reservacion());
        return this.detalleFacturaMapper.toDetalleFactura_Hotel(
                this.detalleFacturaRepository.save(
                        this.detalleFacturaMapper.toDetalleFacturaEntity(detalleFactura_Hotel)
                )
        );
    }
}
