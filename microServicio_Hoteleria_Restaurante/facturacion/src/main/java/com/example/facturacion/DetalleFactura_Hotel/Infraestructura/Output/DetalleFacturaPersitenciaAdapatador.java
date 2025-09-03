package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output;

import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output.GenerarFacturaDetalladaOutputPort;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output.ListarFacturasDetalladasOutputPort;
import com.example.facturacion.DetalleFactura_Hotel.Dominio.DetalleFactura_Hotel;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Mapper.DetalleFacturaMapper;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Output.Repository.DetalleFacturaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Component
@AllArgsConstructor
public class DetalleFacturaPersitenciaAdapatador implements GenerarFacturaDetalladaOutputPort, ListarFacturasDetalladasOutputPort {

    private final DetalleFacturaRepository detalleFacturaRepository;
    private final DetalleFacturaMapper detalleFacturaMapper;
    @Override
    @Transactional
    public DetalleFactura_Hotel GenerarFacturaDetallada(DetalleFactura_Hotel detalleFactura_Hotel) {
        System.out.println(detalleFactura_Hotel.getPrecio().getPrecio()+" --- " + detalleFactura_Hotel.getFecha()+" --- " + detalleFactura_Hotel.getId_reservacion());
        System.out.println(this.detalleFacturaMapper.toDetalleFacturaEntity(detalleFactura_Hotel));
        return this.detalleFacturaMapper.toDetalleFactura_Hotel(
                this.detalleFacturaRepository.save(
                        this.detalleFacturaMapper.toDetalleFacturaEntity(detalleFactura_Hotel)
                )
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<DetalleFactura_Hotel> listarFacturas() {
        return this.detalleFacturaMapper.toListDetalleFactura_Hotel(this.detalleFacturaRepository.findAll());
    }
}
