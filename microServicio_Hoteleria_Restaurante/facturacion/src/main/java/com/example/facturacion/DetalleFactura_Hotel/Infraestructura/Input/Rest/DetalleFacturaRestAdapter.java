package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Input.Rest;

import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input.*;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Service.GenerarFactura.GenerarFacturaDTO;
import com.example.facturacion.DetalleFactura_Hotel.Dominio.ObjetosDeValor.Ganancias;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Input.Rest.Mapper.CreacionDetalleFacturaRestMapper;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Input.Rest.Model.Response.DetalleFacturaResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/detalleFactura")
public class DetalleFacturaRestAdapter {
    private final GenerarFacturaDetalladaInputPort generarFacturaDetalladaInputPort;
    private final ListarFacturasDetalladasInputPort listarFacturasDetalladasInputPort;
    private final CreacionDetalleFacturaRestMapper creacionDetalleFacturaRestMapper;
    private final ListarFacturaReservacionEspecificaInputPort  listarFacturaReservacionEspecificaInputPort;
    private final GanaciasHistoricasInputPort ganaciasHistoricasInputPort;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DetalleFacturaResponseDTO> crearDetalleFactura(@Valid @RequestBody GenerarFacturaDTO generarFacturaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.creacionDetalleFacturaRestMapper.toDetalleFacturaResponseDTO(
                        generarFacturaDetalladaInputPort.generarDetalleFactura((generarFacturaDTO))
                ));
    }

    @GetMapping()
    public List<DetalleFacturaResponseDTO> allDetalleFacturaHotel() {
        return  this.creacionDetalleFacturaRestMapper.toDetalleFacturaResponseDTO(this.listarFacturasDetalladasInputPort.listarFacturas());
    }

    @GetMapping("/{id}")
    public DetalleFacturaResponseDTO FacturaDetalleFacturaEspecificaHotel(@PathVariable UUID id) {
        return  this.creacionDetalleFacturaRestMapper.toDetalleFacturaResponseDTO(this.listarFacturaReservacionEspecificaInputPort.obtenerDetalleFacturacionEspecifica(id));
    }



    @GetMapping("/generarGanancias/{id}")
    public List<Ganancias> generarGanancias(@PathVariable Long id) {
        return  (this.ganaciasHistoricasInputPort.gananciasHistoricas(id));
    }
}
