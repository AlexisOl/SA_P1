package com.example.facturacion.Factura_Restaurante.Infraestructura.Input.Rest;

import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Input.Rest.Model.Output.ResponseDetalleFacturaRestauranteDTO;
import com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Input.GananciasHistoricasRestauranteInputPort;
import com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Input.ListarFacturasUsuarioInputPort;
import com.example.facturacion.Factura_Restaurante.Infraestructura.DTO.Ganancias;
import com.example.facturacion.Factura_Restaurante.Infraestructura.Input.Rest.Mapper.FacturaRestauranteRestMapper;
import com.example.facturacion.Factura_Restaurante.Infraestructura.Input.Rest.Model.Output.ResponseFacturaRestauranteDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/facturaRestaurante")
public class FacturaRestauranteRestAdaptador {

    private final FacturaRestauranteRestMapper  facturaRestauranteRestMapper;
    private final ListarFacturasUsuarioInputPort  listarFacturasUsuarioInputPort;
    private final GananciasHistoricasRestauranteInputPort historicasRestauranteInputPort;

    @GetMapping("/{id}")
    public List<ResponseFacturaRestauranteDTO> ListarDetalleFactura(@PathVariable UUID id) {
        return  this.facturaRestauranteRestMapper.toListResponseFacturaRestauranteDTO(this.listarFacturasUsuarioInputPort.listarFacturas(id));
    }


    @GetMapping("/generarGanancias/{id}")
    public List<Ganancias> generarGanancias(@PathVariable UUID id) {
        return  (this.historicasRestauranteInputPort.gananciasHistoricas(id));
    }
}
